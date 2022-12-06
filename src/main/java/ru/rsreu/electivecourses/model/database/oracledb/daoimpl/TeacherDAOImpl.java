package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.util.DBHelper.buildElectiveCourse;
import static ru.rsreu.electivecourses.util.DBHelper.buildUser;

public class TeacherDAOImpl implements TeacherDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public TeacherDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public List<ElectiveCourse> getCoursesByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.courses");

        List<ElectiveCourse> courses = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, teacherId);
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
}
