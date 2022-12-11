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
        String[] markedIds = request.getParameterValues("block");

        if (markedIds == null) {
            commandResult = new ShowBlockUserFormCommand().execute(request);
            commandResult.addAttribute("result", "Пользователи для разблокировки не выбраны");
        } else {

            List<Long> ids = Arrays.stream(markedIds)
                    .collect(Collectors.toList())
                    .stream()
                    .map(Long::valueOf)
                    .collect(Collectors.toList());

            boolean unblocked = moderatorDAO.unblockUser(ids);
            commandResult = new ShowBlockUserFormCommand().execute(request);
            if (unblocked) {
                commandResult.addAttribute("result", "Пользователи разблокированы");
            } else {
                commandResult.addAttribute("result", "Пользователи не разблокированы");
            }
        }

        return commandResult;
    }
}
