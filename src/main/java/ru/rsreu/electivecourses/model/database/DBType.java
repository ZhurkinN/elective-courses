package ru.rsreu.electivecourses.model.database;

import ru.rsreu.electivecourses.model.database.oracledb.OracleDBDAOFactory;

public class DBType {
    public static DAOFactory getDAOFactory() {
        DAOFactory oracleDBDAOFactory = null;
        oracleDBDAOFactory = OracleDBDAOFactory.getInstance();
        return oracleDBDAOFactory;
    }
}
