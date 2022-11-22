package ru.rsreu.electivecourses.model.database;

import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.RoleDAOImpl;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.UserDAOImpl;

public abstract class DAOFactory {

    public static DAOFactory getInstance() {
        DAOFactory result = DBType.getDAOFactory();
        return result;

    }

    public abstract RoleDAOImpl getRoleDAO();
    public abstract UserDAOImpl getUserDAO();
}