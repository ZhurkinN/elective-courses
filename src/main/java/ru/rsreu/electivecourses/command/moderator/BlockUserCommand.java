package ru.rsreu.electivecourses.command.moderator;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;

public class BlockUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        CommandResult commandResult;
        User user = (User) request.getSession().getAttribute("user");
        Long moderatorId = user.getId();
        Long id = Long.valueOf(request.getParameter("block"));

        if (!id.equals(moderatorId)) {
            boolean blocked = moderatorDAO.blockUser(id);
            commandResult = new ShowBlockUserFormCommand().execute(request);
            if (blocked) {

                commandResult.addAttribute("result", "Пользователь заблокирован");
            } else {
                commandResult.addAttribute("result", "Пользователь не был заблокирован");
            }
        } else {
            commandResult = new ShowBlockUserFormCommand().execute(request);
            commandResult.addAttribute("result", "Вы не можете заблокировать сами себя :)");
        }

        return commandResult;
    }
}
