package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditUserCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdministratorDAO adminDAO = (AdministratorDAO) request.getServletContext().getAttribute("administratorDAO");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Long roleId;

        User user = (User) request.getSession().getAttribute("user");
        if (login.equals(user.getLogin())) {
            roleId = user.getRoleId();
        } else {
            roleId = Long.valueOf(request.getParameter("role"));
        }
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");

        boolean edited = adminDAO.editUser(login, password, roleId, name, surname, patronymic);
        CommandResult commandResult = new ShowEditingUserFormCommand().execute(request);
        if (edited) {
            commandResult.addAttribute("result", "Пользователь успешно изменён.");
        } else {
            commandResult.addAttribute("result", "Пользователь не был найден.");
        }
        List<User> users = adminDAO.getAllUsers();
        commandResult.addAttribute("usersList", users);
        return commandResult;
    }
}
