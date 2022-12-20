package ru.rsreu.electivecourses.model.data.dto;

import ru.rsreu.electivecourses.model.data.Attendance;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.IntermediateMark;
import ru.rsreu.electivecourses.model.data.User;

public class StudentReportDTO {

    private User student;
    private User teacher;
    private ElectiveCourse course;
    private IntermediateMark mark;
    private Attendance attendance;

    public StudentReportDTO() {
    }

    public StudentReportDTO(User student, User teacher, ElectiveCourse course, IntermediateMark mark) {
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.mark = mark;
    }

    public StudentReportDTO(User student, User teacher, ElectiveCourse course, Attendance attendance) {
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.attendance = attendance;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public ElectiveCourse getCourse() {
        return course;
    }

    public void setCourse(ElectiveCourse course) {
        this.course = course;
    }

    public IntermediateMark getMark() {
        return mark;
    }

    public void setMark(IntermediateMark mark) {
        this.mark = mark;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
