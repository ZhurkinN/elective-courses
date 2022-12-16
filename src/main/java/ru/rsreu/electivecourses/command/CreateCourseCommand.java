package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class CreateCourseCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        boolean created = teacherDAO.createCourse(teacherId, title, description);

        CommandResult commandResult = new ShowCreatingNewCourseFormCommand().execute(request);

        if (created) {
            commandResult.addAttribute("result", "Курс успешно создан.");
        } else {
            commandResult.addAttribute("result", "Курс не был создан.");
        }

        return commandResult;
    }
}
