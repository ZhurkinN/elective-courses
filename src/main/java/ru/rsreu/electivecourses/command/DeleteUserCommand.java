package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        CommandResult commandResult = new CommandResult("/WEB-INF/deleteUser.jsp", ActionType.FORWARD);
        Long id = Long.valueOf(request.getParameter("id"));
        boolean deleted = adminDAO.deleteUser(id);
        if (deleted) {
            commandResult.addAttribute("result", "Пользователь удалён.");
        } else {
            commandResult.addAttribute("result", "Не было удалено пользователей.");
        }
        List<User> users = adminDAO.getAllUsers();
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
