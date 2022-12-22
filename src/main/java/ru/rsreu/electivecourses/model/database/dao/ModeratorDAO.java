package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;

import java.util.List;

/**
 * DAO interface for moderator's actions
 */
public interface ModeratorDAO {

    /**
     * Gets active users
     * @return list of active user
     */
    List<User> getActiveUsers();

    /**
     * Blocks user by id
     * @param id user's id
     * @return Was user blocked or not
     */
    boolean blockUser(Long id);

    /**
     * Unblocks user by id
     * @param id user's id
     * @return Was user unblocked or not
     */
    boolean unblockUser(Long id);

    /**
     * Gets all users in system
     * @return list of all users
     */
    List<ElectiveCourse> getAllCourses();

    /**
     * Deletes course by id
     * @param courseId course's id
     * @return Was course deleted or not
     */
    boolean deleteCourse(Long courseId);
}
