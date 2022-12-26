package ru.rsreu.electivecourses.command.moderator;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowBlockUserFormCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO administratorDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        List<User> users = administratorDAO.getAllUsers();
        CommandResult commandResult = new CommandResult("/JSP/blockUser.jsp", ActionType.FORWARD);
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
