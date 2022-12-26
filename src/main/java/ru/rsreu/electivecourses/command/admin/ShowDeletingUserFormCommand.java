package ru.rsreu.electivecourses.command.admin;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowDeletingUserFormCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        List<User> users = adminDAO.getAllUsers();
        CommandResult commandResult = new CommandResult("/JSP/deleteUser.jsp", ActionType.FORWARD);
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
