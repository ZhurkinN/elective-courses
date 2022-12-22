package ru.rsreu.electivecourses.model.data;

import java.sql.Date;

/**
 * Data-class describes Intermediate mark's entity in DB
 */
public class IntermediateMark {

    /**
     * Entity's fields
     */
    private Long id;
    private Long courseId;
    private Long studentId;
    private Integer mark;
    private Date markDate;

    /**
     * Empty constructor for building object with setters
     */
    public IntermediateMark() {
    }

    /**
     * Constructor with all fields
     */
    public IntermediateMark(Long id, Long courseId, Long studentId, Integer mark, Date markDate) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.mark = mark;
        this.markDate = markDate;
    }

    /**
     * Getters and Setters of class's fields
     */
    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
