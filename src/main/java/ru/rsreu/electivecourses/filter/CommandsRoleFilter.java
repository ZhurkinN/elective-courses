package ru.rsreu.electivecourses.filter;

import ru.rsreu.electivecourses.command.CommandFactory;
import ru.rsreu.electivecourses.model.data.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.rsreu.electivecourses.constant.RoleCommandTypeConstantsKeeper.ALL_USERS_ACCESS_ROLE_ID;

public class CommandsRoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String commandText = request.getParameter("command");
        User user = (User) request.getSession().getAttribute("user");


        if (commandText == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            CommandFactory commandFactory = new CommandFactory();
            Long commandRoleId = commandFactory.defineCommandsRole(commandText);

            if (user == null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {

                Long userRoleId = user.getRoleId();
                if (commandRoleId.equals(ALL_USERS_ACCESS_ROLE_ID)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }

                if (commandRoleId.equals(userRoleId)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "?command=returnToMain").forward(request, response);
                }
            }
        }

    }
}
