package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class SetFinalMarkCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        Long studentId = Long.valueOf(request.getParameter("studentId"));
        Long courseId = Long.valueOf(request.getParameter("courseId"));
        String finalMark = request.getParameter("mark");
        boolean set = teacherDAO.setFinalMark(studentId, courseId, finalMark);

        CommandResult commandResult = new ShowSettingGrades().execute(request);
        if (set) {
            commandResult.addAttribute("result", "Оценка успешно выставлена!");
        } else {
            commandResult.addAttribute("result", "Оценка не была выставлена!");
        }
        return commandResult;
    }
}
