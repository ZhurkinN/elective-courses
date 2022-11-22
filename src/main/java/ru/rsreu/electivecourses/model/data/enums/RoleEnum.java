package ru.rsreu.electivecourses.model.data.enums;

import ru.rsreu.electivecourses.model.data.Role;
import ru.rsreu.electivecourses.model.database.DAOFactory;

public enum RoleEnum {

    ADMIN(1),
    MODERATOR(2),
    TEACHER(3),
    STUDENT(4);

    private final int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public Role getRole() {
        return new Role((long) id, getRoleTitle(id));
    }

    private String getRoleTitle(int id) {
        return DAOFactory.getInstance()
                .getRoleDAO()
                .getTitleById((long) id);
    }

}
