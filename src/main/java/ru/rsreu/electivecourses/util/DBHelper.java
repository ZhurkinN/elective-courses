package ru.rsreu.electivecourses.util;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

    private DBHelper() {
    }

    public static User buildUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRoleId(resultSet.getLong("role_id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPatronymic(resultSet.getString("patronymic"));
        user.setAuthorized(resultSet.getInt("is_authorized") == 1);
        user.setActive(resultSet.getInt("is_active") == 1);
        return user;
    }

    public static ElectiveCourse buildElectiveCourse(ResultSet resultSet) throws SQLException {
        ElectiveCourse course = new ElectiveCourse();
        course.setId(resultSet.getLong("id"));
        course.setTeacherId(resultSet.getLong("teacher_id"));
        course.setTitle(resultSet.getString("title"));
        course.setDescription(resultSet.getString("description"));
        return course;
    }
}
