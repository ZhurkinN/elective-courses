package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.User;

import java.util.List;

public interface AdministratorDAO {

    List<User> getAuthorizedUsers();

    List<User> getAllUsers();

    boolean createUser(String login, String password, Long roleId, String name, String surname, String patronymic);

    boolean deleteUser(Long id);

    boolean editUser(String login, String password, Long roleId, String name, String surname, String patronymic);
}
