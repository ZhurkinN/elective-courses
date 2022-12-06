package ru.rsreu.electivecourses.model.database.oracledb;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.database.DAOFactory;
import ru.rsreu.electivecourses.model.database.dao.*;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.AdministratorDAOImpl;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.ModeratorDAOImpl;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.RoleDAOImpl;
import ru.rsreu.electivecourses.model.database.oracledb.daoimpl.UserDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private final Resourcer resourcer = ProjectResourcer.getInstance();
    private Connection connection;
    private RoleDAO roleDAO;
    private UserDAO userDAO;
    private StudentDAO studentDAO;
    private TeacherDAO teacherDAO;
    private AdministratorDAO administratorDAO;

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
        return new UserDAOImpl(connection);
    }

    @Override
    public RoleDAOImpl getTeacherDAO() {
        return new RoleDAOImpl(connection);
    }

    @Override
    public UserDAOImpl getStudentDAO() {
        return new UserDAOImpl(connection);
    }

    @Override
    public AdministratorDAOImpl getAdministratorDAO() {
        return new AdministratorDAOImpl(connection);
    }

    @Override
    public ModeratorDAOImpl getModeratorDAO() {
        return new ModeratorDAOImpl(connection);
    }


    private void connected() throws SQLException, MissingResourceException, ClassNotFoundException {
        Class.forName(resourcer.getString("db.driver"));
        String url = resourcer.getString("db.url");
        String user = resourcer.getString("db.name");
        String password = resourcer.getString("db.password");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to oracle DB!");
    }

}
