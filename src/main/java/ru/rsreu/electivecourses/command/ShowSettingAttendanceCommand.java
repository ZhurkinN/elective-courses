package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.AttendanceDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowSettingAttendanceCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        List<AttendanceDTO> attendanceInfoList = teacherDAO.getAttendanceInfoByTeacherId(teacherId);
        List<CourseDetailsDTO> courseParticipantsInfoList = teacherDAO.getCourseParticipantsByTeacherId(teacherId);

        CommandResult commandResult = new CommandResult("/WEB-INF/setAttendance.jsp", ActionType.FORWARD);
        commandResult.addAttribute("attendanceList", attendanceInfoList);
        commandResult.addAttribute("userList", courseParticipantsInfoList);
        return commandResult;
    }
}
