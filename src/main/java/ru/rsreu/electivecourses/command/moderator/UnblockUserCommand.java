package ru.rsreu.electivecourses.command.moderator;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;

public class UnblockUserCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        CommandResult commandResult;
        Long id = Long.valueOf(request.getParameter("unblock"));

        boolean unblocked = moderatorDAO.unblockUser(id);
        commandResult = new ShowBlockUserFormCommand().execute(request);
        if (unblocked) {
            commandResult.addAttribute("result", "Пользователь разблокирован");
        } else {
            commandResult.addAttribute("result", "Пользователь не был разблокирован");
        }

        return commandResult;
    }
}
