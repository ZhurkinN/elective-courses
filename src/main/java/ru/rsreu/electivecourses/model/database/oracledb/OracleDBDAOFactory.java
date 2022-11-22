package ru.rsreu.electivecourses.model.database.oracledb;

import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.DAOFactory;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.RoleDAOImpl;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.UserDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;
    private RoleDAO roleDAO;
    private UserDAO userDAO;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance() {
        OracleDBDAOFactory factory = instance;
        try {
            if (instance == null) {
                synchronized (OracleDBDAOFactory.class) {
                    instance = factory = new OracleDBDAOFactory();
                    factory.connected();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }

    @Override
    public RoleDAOImpl getRoleDAO() {
        return new RoleDAOImpl(connection);
    }

    @Override
    public UserDAOImpl getUserDAO() {
        return null;
    }

    private void connected() throws SQLException, MissingResourceException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "1234";
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to oracle DB!");
    }

}
