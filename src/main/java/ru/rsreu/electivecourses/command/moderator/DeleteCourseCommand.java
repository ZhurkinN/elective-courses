package ru.rsreu.electivecourses.command.moderator;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import javax.servlet.http.HttpServletRequest;

public class DeleteCourseCommand extends Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        ModeratorDAO moderatorDAO = (ModeratorDAO) request.getServletContext().getAttribute("moderatorDAO");
        Long courseId = Long.valueOf(request.getParameter("delete"));
        boolean deleted = moderatorDAO.deleteCourse(courseId);
        CommandResult commandResult = new ShowDeletingCourseCommand().execute(request);
        if (deleted) {
            commandResult.addAttribute("result", "Курс удалён.");
        } else {
            commandResult.addAttribute("result", "Курс не был удален.");
        }
        return commandResult;
    }
}
