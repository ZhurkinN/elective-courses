package ru.rsreu.electivecourses.model.data.enums;

public enum RoleEnum {

    ADMIN("Administrator"),
    MODERATOR("Moderator"),
    TEACHER("Teacher"),
    STUDENT("Student");

    private String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
