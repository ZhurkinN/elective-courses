package ru.rsreu.electivecourses.model.data;

import ru.rsreu.electivecourses.model.database.DAOFactory;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

public class Role {

    private Long id;
    private String roleName;

    private Role() {
    }

    public Role(Long id, RoleDAO roleDAO) {
        this.id = id;
        this.roleName = getRoleTitle(id, roleDAO);
    }

    private String getRoleTitle(Long id, RoleDAO roleDAO) {
        return roleDAO.getTitleById(id);
    }

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
