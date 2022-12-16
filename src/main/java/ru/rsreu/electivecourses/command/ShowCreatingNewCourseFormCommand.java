package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCreatingNewCourseFormCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        List<ElectiveCourse> courses = teacherDAO.getNotStartedCoursesByTeacherId(teacherId);
        CommandResult commandResult = new CommandResult("/WEB-INF/createCourse.jsp", ActionType.FORWARD);

        commandResult.addAttribute("id", teacherId);
        commandResult.addAttribute("notStartedCoursesList", courses);
        return commandResult;
    }
}
