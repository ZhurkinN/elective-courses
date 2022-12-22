package ru.rsreu.electivecourses.command.teacher;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class StartCourseCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        Long courseId = Long.valueOf(request.getParameter("start"));
        boolean started = teacherDAO.startCourse(courseId);
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        CommandResult commandResult = openTeachersMainPage(teacherDAO, teacherId);

        if (started) {
            commandResult.addAttribute("result", "Вы начали курс!");
        } else {
            commandResult.addAttribute("result", "Не удалось начать курс.");
        }

        return commandResult;
    }
}
