package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        RoleDAO roleDAO = (RoleDAO) request.getServletContext().getAttribute("roleDAO");
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userDAO.getUserByLogin(login);
        CommandResult commandResult;

        if (user == null) {
            commandResult = new CommandResult("/WEB-INF/login.jsp", ActionType.FORWARD);
            commandResult.addAttribute("error", "Пользователя с таким логином не найдено!");
            commandResult.addAttribute("requestedURL", request.getParameter("requestedURL"));
        } else if (!user.isActive()) {
            commandResult = new CommandResult("/WEB-INF/login.jsp", ActionType.FORWARD);
            commandResult.addAttribute("error", "Пользователь заблокирован!");
            commandResult.addAttribute("requestedURL", request.getParameter("requestedURL"));
        } else {
            if (user.getPassword().equals(password)) {
                userDAO.loginUser(user.getId());
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("name", user.getName());
                commandResult = getCommandResultByRole(user, roleDAO, adminDAO, moderatorDAO);
            } else {
                commandResult = new CommandResult("/WEB-INF/login.jsp", ActionType.FORWARD);
                commandResult.addAttribute("error", "Неверный пароль!");
                commandResult.addAttribute("requestedURL", request.getParameter("requestedURL"));
            }
        }
        return commandResult;
    }

    private static CommandResult getCommandResultByRole(User user, RoleDAO roleDAO, AdministratorDAO administratorDAO, ModeratorDAO moderatorDAO) {
        Role role = new Role(user.getRoleId(), roleDAO);
        String roleName = role.getRoleName();
        CommandResult commandResult = null;

        if (roleName.equals(RoleEnum.ADMIN.getRoleName())) {
            commandResult = new CommandResult("/WEB-INF/adminPage.jsp", ActionType.FORWARD);
            List<User> users = administratorDAO.getAuthorizedUsers();
            commandResult.addAttribute("usersList", users);
        }

        if (roleName.equals(RoleEnum.MODERATOR.getRoleName())) {
            commandResult = new CommandResult("/WEB-INF/moderatorPage.jsp", ActionType.FORWARD);
            List<User> users = moderatorDAO.getActiveUsers();
            commandResult.addAttribute("usersList", users);
        }

        if (roleName.equals(RoleEnum.STUDENT.getRoleName())) {
            commandResult = new CommandResult("/WEB-INF/studentPage.jsp", ActionType.FORWARD);
        }

        if (roleName.equals(RoleEnum.TEACHER.getRoleName())) {
            commandResult = new CommandResult("/WEB-INF/teacherPage.jsp", ActionType.FORWARD);
        }

        return commandResult;
    }
}
