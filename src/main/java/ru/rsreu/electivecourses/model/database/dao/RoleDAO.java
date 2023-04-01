package ru.rsreu.electivecourses.model.database.dao;

/**
 * DAO interface for actions with roles
 */
public interface RoleDAO {

    /**
     * Gets title of role by id
     *
     * @param id role's id
     * @return role's title
     */
    String getTitleById(Long id);
}
