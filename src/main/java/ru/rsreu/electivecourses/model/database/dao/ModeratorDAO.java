package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;

import java.util.List;

public interface ModeratorDAO {

    List<User> getActiveUsers();

    boolean blockUser(Long id);

    boolean unblockUser(Long id);

    List<ElectiveCourse> getAllCourses();

    boolean deleteCourse(Long courseId);
}
