package ru.rsreu.electivecourses.command.teacher;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.IntermediateMarksDTO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowSettingGradesCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        List<CourseDetailsDTO> detailsList = teacherDAO.getCourseDetailsInfoByTeacherId(teacherId);
        List<IntermediateMarksDTO> marksInfoList = teacherDAO.getIntermediateMarksInfoByTeacherId(teacherId);
        List<CourseDetailsDTO> courseParticipantsInfoList = teacherDAO.getCourseParticipantsByTeacherId(teacherId);

        CommandResult commandResult = new CommandResult("/JSP/setGrades.jsp", ActionType.FORWARD);
        commandResult.addAttribute("detailsList", detailsList);
        commandResult.addAttribute("marksList", marksInfoList);
        commandResult.addAttribute("setMarksList", courseParticipantsInfoList);
        return commandResult;
    }
}
