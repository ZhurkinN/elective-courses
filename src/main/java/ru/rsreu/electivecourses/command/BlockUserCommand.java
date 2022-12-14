package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;

public class BlockUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        CommandResult commandResult;
        Long id = Long.valueOf(request.getParameter("block"));

        boolean blocked = moderatorDAO.blockUser(id);
        commandResult = new ShowBlockUserFormCommand().execute(request);
        if (blocked) {
            commandResult.addAttribute("result", "Пользователь заблокирован");
        } else {
            commandResult.addAttribute("result", "Пользователь не был заблокирован");
        }

        return commandResult;
    }
}
