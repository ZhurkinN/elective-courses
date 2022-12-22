package ru.rsreu.electivecourses.model.data;

import java.sql.Date;

/**
 * Data-class describes Attendance's entity in DB
 */
public class Attendance {

    /**
     * Entity's fields
     */
    private Long id;
    private Long courseId;
    private Long studentId;
    private Integer lessonNumber;
    private boolean isVisited;
    private Date attendanceDate;

    /**
     * Empty constructor for building object with setters
     */
    public Attendance() {
    }

    /**
     * Constructor with all fields
     */
    public Attendance(Long id, Long courseId, Long studentId, Integer lessonNumber, boolean isVisited, Date attendanceDate) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.lessonNumber = lessonNumber;
        this.isVisited = isVisited;
        this.attendanceDate = attendanceDate;
    }

    /**
     * Getters and Setters of class's fields
     */
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
