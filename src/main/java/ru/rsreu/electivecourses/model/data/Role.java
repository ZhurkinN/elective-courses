package ru.rsreu.electivecourses.model.data;

import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

/**
 * Data-class describes Role's entity in DB
 */
public class Role {

    /**
     * Entity's fields
     */
    private Long id;
    private String roleName;

    /**
     * Unavailable empty constructor
     */
    private Role() {
    }

    /**
     * Constructor with all fields
     */
    public Role(Long id, RoleDAO roleDAO) {
        this.id = id;
        this.roleName = getRoleTitle(id, roleDAO);
    }

    /**
     * Defines title of role
     *
     * @param id      role's id
     * @param roleDAO DAO for role's entities
     * @return role's title
     */
    private String getRoleTitle(Long id, RoleDAO roleDAO) {
        return roleDAO.getTitleById(id);
    }

    /**
     * Getters and Setters of class's fields
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
