package ru.rsreu.electivecourses.listener;

import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDestroyedListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        HttpSessionListener.super.sessionDestroyed(sessionEvent);
        UserDAO userDAO = (UserDAO) sessionEvent.getSession().getServletContext().getAttribute("userDAO");
        User user = (User) sessionEvent.getSession().getAttribute("user");
        Long userId = user.getId();
        userDAO.logoutUser(userId);
    }
}
