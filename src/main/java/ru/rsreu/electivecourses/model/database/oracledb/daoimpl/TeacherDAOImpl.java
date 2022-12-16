package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.CourseDetails;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.model.database.oracledb.daoimpl.AdministratorDAOImpl.MINIMUM_ROWS_CHANGED;
import static ru.rsreu.electivecourses.util.DBHelper.*;

public class TeacherDAOImpl implements TeacherDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public TeacherDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public boolean startCourse(Long courseId) {
        String query = resourcer.getString("query.teacher.course.start");
        Date startDate = new Date(System.currentTimeMillis());
        int rowsChanged = 0;

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, startDate);
            statement.setLong(2, courseId);
            rowsChanged = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsChanged > 0;
    }

    @Override
    public boolean createCourse(Long id, String title, String description) {
        String query = resourcer.getString("query.teacher.course.create");
        boolean created = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            created = statement.executeUpdate() > MINIMUM_ROWS_CHANGED;
            System.out.println(title + " " + description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public List<CourseDetailsDTO> getCourseDetailsInfoByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.details");
        List<CourseDetailsDTO> detailsList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ElectiveCourse electiveCourse = buildElectiveCourse(resultSet);
                CourseDetails courseDetails = buildCourseDetails(resultSet);
                User user = buildUser(resultSet);
                detailsList.add(new CourseDetailsDTO(user, electiveCourse, courseDetails));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailsList;
    }

    @Override
    public boolean setFinalMark(Long studentId, Long courseId, String finalMark) {
        String query = resourcer.getString("query.teacher.set.mark.final");

        int rowsChanged = 0;
        try(PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, finalMark);
            statement.setLong(2, courseId);
            statement.setLong(3, studentId);
            rowsChanged = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsChanged > MINIMUM_ROWS_CHANGED;
    }

    @Override
    public List<ElectiveCourse> getStartedCoursesByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.started.courses");
        return getCoursesById(query, teacherId);
    }

    @Override
    public List<ElectiveCourse> getNotStartedCoursesByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.not.started.courses");
        return getCoursesById(query, teacherId);
    }

    private List<ElectiveCourse> getCoursesById(String query, Long teacherId) {
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
