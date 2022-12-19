package ru.rsreu.electivecourses.util;

import ru.rsreu.electivecourses.model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

    private DBHelper() {
    }

    public static User buildUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRoleId(resultSet.getLong("role_id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPatronymic(resultSet.getString("patronymic"));
        user.setAuthorized(resultSet.getInt("is_authorized") == 1);
        user.setActive(resultSet.getInt("is_active") == 1);

        return user;
    }

    public static ElectiveCourse buildElectiveCourse(ResultSet resultSet) throws SQLException {
        ElectiveCourse course = new ElectiveCourse();

        course.setId(resultSet.getLong("id"));
        course.setTeacherId(resultSet.getLong("teacher_id"));
        course.setTitle(resultSet.getString("title"));
        course.setDescription(resultSet.getString("description"));
        course.setStartDate(resultSet.getDate("start_date"));
        course.setStarted(resultSet.getInt("is_started") == 1);

        return course;
    }

    public static CourseDetails buildCourseDetails(ResultSet resultSet) throws SQLException {
        CourseDetails details = new CourseDetails();

        details.setCourseId(resultSet.getLong("course_id"));
        details.setStudentId(resultSet.getLong("student_id"));
        details.setFinalMark(resultSet.getString("final_mark"));

        return details;
    }

    public static IntermediateMark buildIntermediateMark(ResultSet resultSet) throws SQLException {
        IntermediateMark mark = new IntermediateMark();

        mark.setId(resultSet.getLong("id"));
        mark.setCourseId(resultSet.getLong("course_id"));
        mark.setStudentId(resultSet.getLong("student_id"));
        mark.setMark(resultSet.getInt("mark"));
        mark.setMarkDate(resultSet.getDate("mark_date"));

        return mark;
    }

    public static Attendance buildAttendance(ResultSet resultSet) throws SQLException {
        Attendance attendance = new Attendance();

        attendance.setId(resultSet.getLong("id"));
        attendance.setCourseId(resultSet.getLong("course_id"));
        attendance.setCourseId(resultSet.getLong("student_id"));
        attendance.setLessonNumber(resultSet.getInt("lesson_number"));
        attendance.setVisited(resultSet.getInt("is_visited") == 1);
        attendance.setAttendanceDate(resultSet.getDate("attendance_date"));

        return attendance;
    }
}
