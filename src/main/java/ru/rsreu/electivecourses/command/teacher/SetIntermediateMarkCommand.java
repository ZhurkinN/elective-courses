package ru.rsreu.electivecourses.command.teacher;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class SetIntermediateMarkCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        Long studentId = Long.valueOf(request.getParameter("studentId"));
        Long courseId = Long.valueOf(request.getParameter("courseId"));
        Integer mark = Integer.valueOf(request.getParameter("intermediateMark"));
        boolean set = teacherDAO.setIntermediateMark(courseId, studentId, mark);

        CommandResult commandResult = new ShowSettingGradesCommand().execute(request);
        if (set) {
            commandResult.addAttribute("result", "Промежуточная оценка успешно выставлена!");
        } else {
            commandResult.addAttribute("result", "Оценка не была выставлена!");
        }

        return commandResult;
    }
}
