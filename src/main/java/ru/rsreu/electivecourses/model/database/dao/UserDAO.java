package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.User;

public interface UserDAO {

    void loginUser(Long id);
    void logoutUser(Long id);

    User getUserByLogin(String login);
}
