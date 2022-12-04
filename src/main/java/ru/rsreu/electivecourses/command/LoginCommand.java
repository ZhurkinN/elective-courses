package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends Command{
    @Override
    public CommandResult execute(HttpServletRequest request) {
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userDAO.getUserByLogin(login);
        CommandResult commandResult = null;

        if (user == null || !user.isActive()) {

        } else {
            if (user.getPassword().equals(password)) {
                userDAO.loginUser(user.getId());
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("name", user.getName());
                commandResult = new CommandResult("/WEB-INF/main.jsp", ActionType.FORWARD);
            } else {

            }
        }
        return commandResult;
    }
}
