package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.rsreu.electivecourses.util.DBHelper.buildUser;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }


    @Override
    public void loginUser(Long id) {
        String query = resourcer.getString("query.user.login");

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logoutUser(Long id) {
        String query = resourcer.getString("query.user.logout");

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        String query = resourcer.getString("query.user.get.by.login");

        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = buildUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
