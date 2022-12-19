package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.AdministratorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.util.DBHelper.buildUser;

public class AdministratorDAOImpl implements AdministratorDAO {

    public static final int MINIMUM_ROWS_CHANGED = 0;
    private final Connection connection;
    private final Resourcer resourcer;

    public AdministratorDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public List<User> getAuthorizedUsers() {
        String query = resourcer.getString("query.admin.get.authorized.users");

        List<User> activeUsers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = buildUser(resultSet);
                activeUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activeUsers;
    }

    @Override
    public List<User> getAllUsers() {
        String query = resourcer.getString("query.admin.get.all.users");

        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = buildUser(resultSet);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean createUser(String login, String password, Long roleId, String name, String surname, String patronymic) {
        String query = resourcer.getString("query.admin.create.user");
        boolean created = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, login);
            statement.setString(2, password);
            statement.setLong(3, roleId);
            statement.setString(4, name);
            statement.setString(5, surname);
            statement.setString(6, patronymic);
            created = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean deleteUser(Long id) {
        String query = resourcer.getString("query.admin.delete.user");
        boolean deleted = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            deleted = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }

    @Override
    public boolean editUser(String login, String password, Long roleId, String name, String surname, String patronymic) {
        String query = resourcer.getString("query.admin.edit.user");
        boolean edited = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, password);
            statement.setLong(2, roleId);
            statement.setString(3, name);
            statement.setString(4, surname);
            statement.setString(5, patronymic);
            statement.setString(6, login);
            edited = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return edited;
    }
}
