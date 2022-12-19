package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.CourseDetails;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.database.dao.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.model.database.oracledb.daoimpl.AdministratorDAOImpl.MINIMUM_ROWS_CHANGED;
import static ru.rsreu.electivecourses.util.DBHelper.*;

public class StudentDAOImpl implements StudentDAO {

    private final static String EXPELLED_MARK = "Отчислен";
    private final Connection connection;
    private final Resourcer resourcer;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public List<CourseDetailsDTO> getCoursesByStudentId(Long studentId) {
        String query = resourcer.getString("query.student.get.courses");
        List<CourseDetailsDTO> courses = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CourseDetails courseDetails = buildCourseDetails(resultSet);
                User teacher = buildUser(resultSet);
                ElectiveCourse course = buildElectiveCourse(resultSet);
                courses.add(new CourseDetailsDTO(teacher, course, courseDetails));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<AdvertisementDTO> getAvailableCourses(Long studentId) {
        String query = resourcer.getString("query.student.get.advertisements");
        List<AdvertisementDTO> availableCoursesInfoList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ElectiveCourse course = buildElectiveCourse(resultSet);
                User teacher = buildUser(resultSet);
                availableCoursesInfoList.add(new AdvertisementDTO(teacher, course));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableCoursesInfoList;
    }

    @Override
    public boolean joinCourse(Long studentId, Long courseId) {
        String query = resourcer.getString("query.student.join.course");

        int rowsChanged = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, courseId);
            statement.setLong(2, studentId);
            rowsChanged = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsChanged > MINIMUM_ROWS_CHANGED;
    }

    @Override
    public boolean leaveCourse(Long studentId, Long courseId) {
        String query = resourcer.getString("query.student.leave.course");

        int rowsChanged = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, EXPELLED_MARK);
            statement.setLong(2, studentId);
            statement.setLong(3, courseId);
            rowsChanged = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsChanged > MINIMUM_ROWS_CHANGED;
    }
}
