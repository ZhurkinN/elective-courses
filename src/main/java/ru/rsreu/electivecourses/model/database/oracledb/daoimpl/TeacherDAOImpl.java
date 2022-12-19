package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.data.*;
import ru.rsreu.electivecourses.model.data.dto.AttendanceDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.IntermediateMarksDTO;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.electivecourses.model.database.oracledb.daoimpl.AdministratorDAOImpl.MINIMUM_ROWS_CHANGED;
import static ru.rsreu.electivecourses.util.DBHelper.*;

public class TeacherDAOImpl implements TeacherDAO {

    private final static String IN_ACTION_PARTICIPANT_MARK = "Нет оценки";
    private final Connection connection;
    private final Resourcer resourcer;

    public TeacherDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }

    @Override
    public boolean startCourse(Long courseId) {
        String query = resourcer.getString("query.teacher.course.start");
        int rowsChanged = 0;

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, courseId);
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public List<CourseDetailsDTO> getCourseDetailsInfoByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.details");
        List<CourseDetailsDTO> detailsList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

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
        try (PreparedStatement statement = connection.prepareStatement(query)) {

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
    public List<IntermediateMarksDTO> getIntermediateMarksInfoByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.marks.intermediate");
        List<IntermediateMarksDTO> intermediateMarksInfoList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                IntermediateMark mark = buildIntermediateMark(resultSet);
                ElectiveCourse electiveCourse = buildElectiveCourse(resultSet);
                User user = buildUser(resultSet);
                intermediateMarksInfoList.add(new IntermediateMarksDTO(mark, electiveCourse, user));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intermediateMarksInfoList;
    }

    @Override
    public List<CourseDetailsDTO> getCourseParticipantsByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.course.members");
        List<CourseDetailsDTO> participantsInfoList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, teacherId);
            statement.setString(2, IN_ACTION_PARTICIPANT_MARK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CourseDetails courseDetails = buildCourseDetails(resultSet);
                User user = buildUser(resultSet);
                ElectiveCourse course = buildElectiveCourse(resultSet);
                participantsInfoList.add(new CourseDetailsDTO(user, course, courseDetails));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participantsInfoList;
    }

    @Override
    public boolean setIntermediateMark(Long courseId, Long studentId, Integer mark) {
        String query = resourcer.getString("query.teacher.set.mark.intermediate");

        int rowsChanged = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, courseId);
            statement.setLong(2, studentId);
            statement.setInt(3, mark);
            rowsChanged = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsChanged > MINIMUM_ROWS_CHANGED;
    }

    @Override
    public List<AttendanceDTO> getAttendanceInfoByTeacherId(Long teacherId) {
        String query = resourcer.getString("query.teacher.get.attendance");
        List<AttendanceDTO> attendanceInfoList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Attendance attendance = buildAttendance(resultSet);
                User user = buildUser(resultSet);
                ElectiveCourse course = buildElectiveCourse(resultSet);
                attendanceInfoList.add(new AttendanceDTO(user, attendance, course));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceInfoList;
    }

    @Override
    public boolean setAttendance(Long courseId, Long studentId, Integer attendance, Integer newAttendanceNumber) {
        String query = resourcer.getString("query.teacher.set.attendance");

        int rowsChanged = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, courseId);
            statement.setLong(2, studentId);
            statement.setInt(3, newAttendanceNumber);
            statement.setInt(4, attendance);
            rowsChanged = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsChanged > MINIMUM_ROWS_CHANGED;
    }

    @Override
    public Integer getLastAttendanceNumber(Long studentId, Long courseId) {
        String query = resourcer.getString("query.teacher.get.last.attendance");

        int lastAttendanceNumber = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, studentId);
            statement.setLong(2, courseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lastAttendanceNumber = resultSet.getInt("max");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastAttendanceNumber;
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
