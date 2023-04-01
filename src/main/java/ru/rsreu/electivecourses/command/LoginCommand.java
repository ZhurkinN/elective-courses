package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {

    private static final int MAX_INACTIVE_SESSION_INTERVAL = 300;

    @Override
    public CommandResult execute(HttpServletRequest request) {
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        RoleDAO roleDAO = (RoleDAO) request.getServletContext().getAttribute("roleDAO");
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        StudentDAO studentDAO = (StudentDAO) request.getServletContext().getAttribute("studentDAO");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userDAO.getUserByLogin(login);
        CommandResult commandResult;

        if (user == null) {
            commandResult = new CommandResult("/JSP/login.jsp", ActionType.FORWARD);
            commandResult.addAttribute("error", "Пользователя с таким логином не найдено!");
        } else if (!user.isActive()) {
            commandResult = new CommandResult("/JSP/login.jsp", ActionType.FORWARD);
            commandResult.addAttribute("error", "Пользователь заблокирован!");
        } else {
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(MAX_INACTIVE_SESSION_INTERVAL);
                session.setAttribute("user", user);
                session.setAttribute("name", user.getName());

                userDAO.loginUser(user.getId());
                commandResult = getCommandResultByRole(user, roleDAO, adminDAO, moderatorDAO, teacherDAO, studentDAO);
            } else {
                commandResult = new CommandResult("/JSP/login.jsp", ActionType.FORWARD);
                commandResult.addAttribute("error", "Неверный пароль!");
            }
        }
        return commandResult;
    }

    private static CommandResult getCommandResultByRole(User user,
                                                        RoleDAO roleDAO,
                                                        AdministratorDAO administratorDAO,
                                                        ModeratorDAO moderatorDAO,
                                                        TeacherDAO teacherDAO,
                                                        StudentDAO studentDAO) {
        Role role = new Role(user.getRoleId(), roleDAO);
        String roleName = role.getRoleName();
        CommandResult commandResult = null;

        if (roleName.equals(RoleEnum.ADMIN.getRoleName())) {
            commandResult = openAdministratorsMainPage(administratorDAO);
        }

        if (roleName.equals(RoleEnum.MODERATOR.getRoleName())) {
            commandResult = openModeratorsMainPage(moderatorDAO);
        }

        if (roleName.equals(RoleEnum.STUDENT.getRoleName())) {
            commandResult = openStudentsMainPage(studentDAO, user.getId());
        }

        if (roleName.equals(RoleEnum.TEACHER.getRoleName())) {
            commandResult = openTeachersMainPage(teacherDAO, user.getId());
        }

        return commandResult;
    }
}
