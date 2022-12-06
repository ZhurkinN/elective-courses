package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowEditingUserFormCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        List<User> users = adminDAO.getAllUsers();
        CommandResult commandResult = new CommandResult("/WEB-INF/editUser.jsp", ActionType.FORWARD);
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
