package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class StartCourseCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        Long courseId = Long.valueOf(request.getParameter("start"));
        boolean started = teacherDAO.startCourse(courseId);
        Long id = Long.valueOf(request.getParameter("id"));
        CommandResult commandResult = openTeachersMainPage(teacherDAO, id);

        if (started) {
            commandResult.addAttribute("result", "Вы начали курс!");
        } else {
            commandResult.addAttribute("result", "Не удалось начать курс.");
        }

        return commandResult;
    }
}
