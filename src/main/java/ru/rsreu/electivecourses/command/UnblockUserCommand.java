package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
