package ru.rsreu.electivecourses.command.admin;

import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.CommandResult;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Long roleId = Long.valueOf(request.getParameter("role"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        boolean created = adminDAO.createUser(login, password, roleId, name, surname, patronymic);
        CommandResult commandResult = new ShowCreatingUserFormCommand().execute(request);
        if (created) {
            commandResult.addAttribute("result", "Пользователь успешно создан.");
        } else {
            commandResult.addAttribute("result", "Пользователь не был создан.");
        }
        List<User> users = adminDAO.getAllUsers();
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
