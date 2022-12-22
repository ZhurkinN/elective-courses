package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.ModeratorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.model.database.oracledb.daoimpl.AdministratorDAOImpl.MINIMUM_ROWS_CHANGED;
import static ru.rsreu.electivecourses.util.DBHelper.buildElectiveCourse;
import static ru.rsreu.electivecourses.util.DBHelper.buildUser;

public class ModeratorDAOImpl implements ModeratorDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public ModeratorDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public List<User> getActiveUsers() {
        String query = resourcer.getString("query.moderator.get.users");

        List<User> authorizedUsers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = buildUser(resultSet);
                authorizedUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorizedUsers;
    }

    @Override
    public boolean blockUser(Long id) {
        String query = resourcer.getString("query.moderator.block.user");
        boolean blocked = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            blocked = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blocked;
    }

    @Override
    public boolean unblockUser(Long id) {
        String query = resourcer.getString("query.moderator.unblock.user");
        boolean unblocked = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            unblocked = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unblocked;
    }

    @Override
    public List<ElectiveCourse> getAllCourses() {
        String query = resourcer.getString("query.moderator.get.courses");

        List<ElectiveCourse> courses = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ElectiveCourse course = buildElectiveCourse(resultSet);
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public boolean deleteCourse(Long courseId) {
        String query = resourcer.getString("query.moderator.delete.course");
        boolean deleted = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, courseId);
            deleted = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
