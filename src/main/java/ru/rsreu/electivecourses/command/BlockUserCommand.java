package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BlockUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        CommandResult commandResult = new CommandResult("/WEB-INF/blockUser.jsp", ActionType.FORWARD);
        Long id = Long.valueOf(request.getParameter("id"));
        boolean blocked = moderatorDAO.blockUser(id);
        List<User> users = moderatorDAO.getActiveUsers();
        commandResult.addAttribute("usersList", users);
        if (blocked) {
            commandResult.addAttribute("result", "Пользователь заблокирован");
        } else {
            commandResult.addAttribute("result", "Пользователь не заблокирован");
        }

        return commandResult;
    }
}
