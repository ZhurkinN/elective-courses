package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        RoleDAO roleDAO = (RoleDAO) request.getServletContext().getAttribute("roleDAO");
        Long id = Long.valueOf(request.getParameter("delete"));
        Role role = new Role(id, roleDAO);
        String roleName = role.getRoleName();
        CommandResult commandResult;
        if (!roleName.equals(RoleEnum.ADMIN.getRoleName())) {

            boolean deleted = adminDAO.deleteUser(id);
            commandResult = new ShowDeletingUserFormCommand().execute(request);
            if (deleted) {
                commandResult.addAttribute("result", "Пользователь удалён.");
            } else {
                commandResult.addAttribute("result", "Не было удалено пользователей.");
            }
        } else {
            commandResult = new ShowDeletingUserFormCommand().execute(request);
            commandResult.addAttribute("result", "Вы не можете удалять администраторов");
        }
        return commandResult;
    }
}
