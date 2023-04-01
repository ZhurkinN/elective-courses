package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.User;

import java.util.List;

/**
 * DAO interface for administrator's actions
 */
public interface AdministratorDAO {

    /**
     * Gets authorized users
     *
     * @return list of authorized user
     */
    List<User> getAuthorizedUsers();

    /**
     * Gets all users in system
     *
     * @return list of all users
     */
    List<User> getAllUsers();

    /**
     * Creates new user
     *
     * @param login      user's login
     * @param password   user's password
     * @param roleId     user's role's id
     * @param name       user's name
     * @param surname    user's surname
     * @param patronymic user's patronymic
     * @return Was user created or not
     */
    boolean createUser(String login, String password, Long roleId, String name, String surname, String patronymic);

    /**
     * Deletes user by id
     *
     * @param id user's id
     * @return Was user deleted or not
     */
    boolean deleteUser(Long id);

    /**
     * Edits user
     *
     * @param login      user's login
     * @param password   user's password
     * @param roleId     user's role's id
     * @param name       user's name
     * @param surname    user's surname
     * @param patronymic user's patronymic
     * @return Was user edited or not
     */
    boolean editUser(String login, String password, Long roleId, String name, String surname, String patronymic);
}
