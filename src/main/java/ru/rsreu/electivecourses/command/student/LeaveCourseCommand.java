package ru.rsreu.electivecourses.command.student;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.StudentDAO;

import javax.servlet.http.HttpServletRequest;

public class LeaveCourseCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        StudentDAO studentDAO = (StudentDAO) request.getServletContext().getAttribute("studentDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long studentId = user.getId();
        Long courseId = Long.valueOf(request.getParameter("course"));
        boolean left = studentDAO.leaveCourse(studentId, courseId);

        CommandResult commandResult = new ShowCourseInteractionsCommand().execute(request);
        if (left) {
            commandResult.addAttribute("result", "Вы отчислились с выбранного курса!");
        } else {
            commandResult.addAttribute("result", "Не удалось отчислиться с курса.");
        }
        return commandResult;
    }
}
