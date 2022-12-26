package ru.rsreu.electivecourses.command.student;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.database.dao.StudentDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCourseInteractionsCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        StudentDAO studentDAO = (StudentDAO) request.getServletContext().getAttribute("studentDAO");
        User user = (User) request.getSession().getAttribute("user");
        Long studentId = user.getId();
        List<CourseDetailsDTO> courses = studentDAO.getCoursesByStudentId(studentId);
        List<AdvertisementDTO> availableCoursesInfoList = studentDAO.getAvailableCourses(studentId);

        CommandResult commandResult = new CommandResult("/JSP/interactWithCourse.jsp", ActionType.FORWARD);
        commandResult.addAttribute("currentCoursesList", courses);
        commandResult.addAttribute("advertisementList", availableCoursesInfoList);

        return commandResult;
    }
}
