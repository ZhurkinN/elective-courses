package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;

public class SetAttendanceCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        Long studentId = Long.valueOf(request.getParameter("studentId"));
        Long courseId = Long.valueOf(request.getParameter("courseId"));
        Integer attendance = Integer.valueOf(request.getParameter("attendance"));
        Integer newAttendanceNumber = teacherDAO.getLastAttendanceNumber(studentId, courseId) + 1;
        boolean set = teacherDAO.setAttendance(courseId, studentId, attendance, newAttendanceNumber);

        CommandResult commandResult = new ShowSettingAttendanceCommand().execute(request);
        if (set) {
            commandResult.addAttribute("result", "Посещаемость успешно проставлена!");
        } else {
            commandResult.addAttribute("result", "Посешаемость не была выставлена!");
        }
        return commandResult;
    }
}
