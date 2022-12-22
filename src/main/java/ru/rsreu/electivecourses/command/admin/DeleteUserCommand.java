package ru.rsreu.electivecourses.command.admin;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long administratorId = user.getId();
        Long id = Long.valueOf(request.getParameter("delete"));
        CommandResult commandResult;
        if (!id.equals(administratorId)) {

            boolean deleted = adminDAO.deleteUser(id);
            commandResult = new ShowDeletingUserFormCommand().execute(request);
            if (deleted) {
                commandResult.addAttribute("result", "Пользователь удалён.");
            } else {
                commandResult.addAttribute("result", "Пользователь не был удалён.");
            }
        } else {
            commandResult = new ShowDeletingUserFormCommand().execute(request);
            commandResult.addAttribute("result", "Вы не можете удалить самого себя :)");
        }
        return commandResult;
    }
}
