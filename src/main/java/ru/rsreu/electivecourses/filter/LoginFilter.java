package ru.rsreu.electivecourses.filter;

import ru.rsreu.electivecourses.command.enums.CommandType;
import ru.rsreu.electivecourses.model.data.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String command = request.getParameter("command");
        User user = (User) request.getSession().getAttribute("user");

        if (command == null) {

            if (user == null) {
                response.sendRedirect(request.getContextPath() + "?command=showLoginPage");
            } else {
                response.sendRedirect(request.getContextPath() + "?command=returnToMain");
            }
        } else {

            CommandType commandType = CommandType.getCommandType(command);
            if (commandType != CommandType.LOGIN && commandType != CommandType.SHOW_LOGIN_PAGE) {

                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "?command=showLoginPage");
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
