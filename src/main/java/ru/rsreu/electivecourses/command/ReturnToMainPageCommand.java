package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;
import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.enums.RoleEnum;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

import javax.servlet.http.HttpServletRequest;

public class ReturnToMainPageCommand extends Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        RoleDAO roleDAO = (RoleDAO) request.getServletContext().getAttribute("roleDAO");
        User user = (User) request.getSession().getAttribute("user");
        Role role = new Role(user.getRoleId(), roleDAO);
        String roleName = role.getRoleName();
        CommandResult commandResult;

        if (roleName.equals(RoleEnum.ADMIN.getRoleName())) {
            commandResult = new CommandResult("/WEB-INF/adminPage.jsp", ActionType.FORWARD);
        } else {
            commandResult = new CommandResult("/WEB-INF/moderatorPage.jsp", ActionType.FORWARD);
        }
        return commandResult;
    }
}
