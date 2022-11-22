package ru.rsreu.electivecourses.model.data;

import java.sql.Date;

public class CourseDetails {

    private Long courseId;
    private Long studentId;
    private String finalMark;
    private Date startDate;

    private CourseDetails() {
    }

    public CourseDetails(Long courseId, Long studentId, String finalMark, Date startDate) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.finalMark = finalMark;
        this.startDate = startDate;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(String finalMark) {
        this.finalMark = finalMark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
