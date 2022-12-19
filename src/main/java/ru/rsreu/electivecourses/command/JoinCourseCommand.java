package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.StudentDAO;

import javax.servlet.http.HttpServletRequest;

public class JoinCourseCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        StudentDAO studentDAO = (StudentDAO) request.getServletContext().getAttribute("studentDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long studentId = user.getId();
        Long courseId = Long.valueOf(request.getParameter("courseId"));
        boolean joined = studentDAO.joinCourse(studentId, courseId);

        CommandResult commandResult = new ShowCourseInteractionsCommand().execute(request);
        if (joined) {
            commandResult.addAttribute("result", "Вы записаны на выбранный курс!");
        } else {
            commandResult.addAttribute("result", "Не удалось записаться на курс.");
        }
        return commandResult;
    }
}
