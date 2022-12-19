package ru.rsreu.electivecourses.model.database;

import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.*;

public abstract class DAOFactory {

    public static DAOFactory getInstance() {
        DAOFactory result = DBType.getDAOFactory();
        return result;

    }

    public abstract RoleDAOImpl getRoleDAO();

    public abstract UserDAOImpl getUserDAO();

    public abstract TeacherDAOImpl getTeacherDAO();

    public abstract StudentDAOImpl getStudentDAO();

    public abstract AdministratorDAOImpl getAdministratorDAO();

    public abstract ModeratorDAOImpl getModeratorDAO();
}