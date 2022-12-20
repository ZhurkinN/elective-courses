package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReturnToMainPageCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        RoleDAO roleDAO = (RoleDAO) request.getServletContext().getAttribute("roleDAO");
        AdministratorDAO administratorDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        StudentDAO studentDAO = (StudentDAO) request.getServletContext().getAttribute("studentDAO");
        User user = (User) request.getSession().getAttribute("user");
        Role role = new Role(user.getRoleId(), roleDAO);
        String roleName = role.getRoleName();
        CommandResult commandResult;

        if (roleName.equals(RoleEnum.ADMIN.getRoleName())) {
            commandResult = openAdministratorsMainPage(administratorDAO);

        } else if (roleName.equals(RoleEnum.MODERATOR.getRoleName())) {
            commandResult = openModeratorsMainPage(moderatorDAO);

        } else if (roleName.equals(RoleEnum.TEACHER.getRoleName())) {
            commandResult = openTeachersMainPage(teacherDAO, user.getId());

        } else {
            commandResult = openStudentsMainPage(studentDAO, user.getId());
        }

        return commandResult;
    }
}
