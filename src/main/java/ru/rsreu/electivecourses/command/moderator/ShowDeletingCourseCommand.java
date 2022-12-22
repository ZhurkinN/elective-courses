package ru.rsreu.electivecourses.command.moderator;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowDeletingCourseCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        List<ElectiveCourse> courses = moderatorDAO.getAllCourses();
        CommandResult commandResult = new CommandResult("/WEB-INF/deleteCourse.jsp", ActionType.FORWARD);
        commandResult.addAttribute("coursesList", courses);
        return commandResult;
    }
}
