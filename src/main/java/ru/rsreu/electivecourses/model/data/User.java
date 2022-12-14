package ru.rsreu.electivecourses.model.data;

/**
 * Data-class describes User's entity in DB
 */
public class User {

    /**
     * Entity's fields
     */
    private Long id;
    private String login;
    private String password;
    private Long roleId;
    private String name;
    private String surname;
    private String patronymic;
    private boolean isAuthorized;
    private boolean isActive;

    /**
     * Empty constructor for building object with setters
     */
    public User() {
    }

    /**
     * Constructor with all fields
     */
    public User(Long id, String login, String password, Long roleId, String name, String surname, String patronymic, boolean isAuthorized, boolean isActive) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.isAuthorized = isAuthorized;
        this.isActive = isActive;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
