package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        User user = (User) request.getSession(false).getAttribute("user");
        userDAO.logoutUser(user.getId());
        request.getSession().invalidate();
        return new CommandResult(request.getContextPath(), ActionType.REDIRECT);
    }
}
