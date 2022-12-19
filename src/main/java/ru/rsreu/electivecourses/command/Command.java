package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class Command {

    public abstract CommandResult execute(HttpServletRequest request);

    protected static CommandResult openTeachersMainPage(TeacherDAO teacherDAO, Long id) {
        CommandResult commandResult = new CommandResult("/WEB-INF/teacherPage.jsp", ActionType.FORWARD);
        List<ElectiveCourse> startedCourses = teacherDAO.getStartedCoursesByTeacherId(id);
        List<ElectiveCourse> notStartedCourses = teacherDAO.getNotStartedCoursesByTeacherId(id);
        commandResult.addAttribute("startedCoursesList", startedCourses);
        commandResult.addAttribute("notStartedCoursesList", notStartedCourses);
        return commandResult;
    }

    protected static CommandResult openAdministratorsMainPage(AdministratorDAO administratorDAO) {
        CommandResult commandResult = new CommandResult("/WEB-INF/adminPage.jsp", ActionType.FORWARD);
        List<User> users = administratorDAO.getAuthorizedUsers();
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }

    protected static CommandResult openModeratorsMainPage(ModeratorDAO moderatorDAO) {
        CommandResult commandResult = new CommandResult("/WEB-INF/moderatorPage.jsp", ActionType.FORWARD);
        List<User> users = moderatorDAO.getActiveUsers();
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
