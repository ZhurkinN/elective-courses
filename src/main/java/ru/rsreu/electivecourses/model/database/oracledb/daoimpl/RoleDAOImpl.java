package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.database.dao.RoleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public RoleDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public String getTitleById(Long id) {
        String query = "SELECT role.role_name FROM role WHERE id = ?";

        String title = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                title = resultSet.getString("role_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }
}
