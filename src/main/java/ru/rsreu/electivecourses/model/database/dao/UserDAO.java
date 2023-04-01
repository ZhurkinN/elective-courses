package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.User;

/**
 * DAO interface for actions with users
 */
public interface UserDAO {

    /**
     * Logins user with given id
     *
     * @param id user's id
     */
    void loginUser(Long id);

    /**
     * Logouts user with given id
     *
     * @param id user's id
     */
    void logoutUser(Long id);

    /**
     * Gets user with given login
     *
     * @param login user's login
     * @return founded user
     */
    User getUserByLogin(String login);
}
