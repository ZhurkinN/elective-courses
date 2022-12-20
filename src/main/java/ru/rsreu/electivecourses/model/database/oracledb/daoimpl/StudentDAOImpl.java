package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.*;
import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.StudentReportDTO;
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
    private final static String DUPLICATE_DATA_ADDING = "_1";

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

    @Override
    public List<StudentReportDTO> getMarksReport(Long studentId) {
        String query = resourcer.getString("query.student.get.marks.info");

        List<StudentReportDTO> marksInfoList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, studentId);
            statement.setString(2, EXPELLED_MARK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ElectiveCourse course = buildElectiveCourse(resultSet);
                IntermediateMark mark = buildIntermediateMark(resultSet);
                User teacher = buildUser(resultSet);
                User student = buildUser(resultSet);
                marksInfoList.add(new StudentReportDTO(student, teacher, course, mark));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksInfoList;
    }

    @Override
    public List<StudentReportDTO> getAttendanceReport(Long studentId) {
        String query = resourcer.getString("query.student.get.attendance.info");

        List<StudentReportDTO> attendanceInfoList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, studentId);
            statement.setString(2, EXPELLED_MARK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ElectiveCourse course = buildElectiveCourse(resultSet);
                Attendance attendance = buildAttendance(resultSet);
                User teacher = buildUser(resultSet);
                User student = buildUser(resultSet);
                attendanceInfoList.add(new StudentReportDTO(student, teacher, course, attendance));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceInfoList;
    }

    private User buildDuplicateUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id" + DUPLICATE_DATA_ADDING));
        user.setLogin(resultSet.getString("login" + DUPLICATE_DATA_ADDING));
        user.setPassword(resultSet.getString("password" + DUPLICATE_DATA_ADDING));
        user.setRoleId(resultSet.getLong("role_id" + DUPLICATE_DATA_ADDING));
        user.setName(resultSet.getString("name" + DUPLICATE_DATA_ADDING));
        user.setSurname(resultSet.getString("surname" + DUPLICATE_DATA_ADDING));
        user.setPatronymic(resultSet.getString("patronymic" + DUPLICATE_DATA_ADDING));
        user.setAuthorized(resultSet.getInt("is_authorized" + DUPLICATE_DATA_ADDING) == 1);
        user.setActive(resultSet.getInt("is_active" + DUPLICATE_DATA_ADDING) == 1);

        return user;
    }
}
