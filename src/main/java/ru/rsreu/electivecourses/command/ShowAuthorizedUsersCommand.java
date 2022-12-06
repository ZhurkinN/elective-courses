package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAuthorizedUsersCommand extends Command{
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        List<User> users = adminDAO.getAuthorizedUsers();
        CommandResult commandResult = new CommandResult("/WEB-INF/userList.jsp", ActionType.FORWARD);
        commandResult.addAttribute("usersList", users);
        commandResult.addAttribute("title", "Список авторизованных пользователей");

        return commandResult;
    }
}
