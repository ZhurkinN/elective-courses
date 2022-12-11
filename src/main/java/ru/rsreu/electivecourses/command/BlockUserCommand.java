package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlockUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        CommandResult commandResult;
        String[] markedIds = request.getParameterValues("block");

        if (markedIds == null) {
            commandResult = new ShowBlockUserFormCommand().execute(request);
            commandResult.addAttribute("result", "Пользователи для блокировки не выбраны");
        } else {

            List<Long> ids = Arrays.stream(markedIds)
                    .collect(Collectors.toList())
                    .stream()
                    .map(Long::valueOf)
                    .collect(Collectors.toList());

            boolean blocked = moderatorDAO.blockUser(ids);
            commandResult = new ShowBlockUserFormCommand().execute(request);
            if (blocked) {
                commandResult.addAttribute("result", "Пользователи заблокированы");
            } else {
                commandResult.addAttribute("result", "Пользователи не заблокированы");
            }
        }

        return commandResult;
    }
}
