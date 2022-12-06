package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowBlockUserFormCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        List<User> users = moderatorDAO.getActiveUsers();
        CommandResult commandResult = new CommandResult("/WEB-INF/blockUser.jsp", ActionType.FORWARD);
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
