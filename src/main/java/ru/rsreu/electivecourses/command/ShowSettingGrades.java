package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowSettingGrades extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        TeacherDAO teacherDAO = (TeacherDAO) request.getServletContext().getAttribute("teacherDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long teacherId = user.getId();
        List<CourseDetailsDTO> detailsList = teacherDAO.getCourseDetailsInfoByTeacherId(teacherId);
        CommandResult commandResult = new CommandResult("/WEB-INF/setGrades.jsp", ActionType.FORWARD);
        commandResult.addAttribute("detailsList", detailsList);
        return commandResult;
    }
}
