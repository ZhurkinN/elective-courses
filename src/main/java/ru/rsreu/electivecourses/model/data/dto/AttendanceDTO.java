package ru.rsreu.electivecourses.model.data.dto;

import ru.rsreu.electivecourses.model.data.Attendance;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;

public class AttendanceDTO {

    private User user;
    private Attendance attendance;
    private ElectiveCourse course;

    public AttendanceDTO() {
    }

    public AttendanceDTO(User user, Attendance attendance, ElectiveCourse course) {
        this.user = user;
        this.attendance = attendance;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public ElectiveCourse getCourse() {
        return course;
    }

    public void setCourse(ElectiveCourse course) {
        this.course = course;
    }
}
