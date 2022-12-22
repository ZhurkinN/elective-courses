package ru.rsreu.electivecourses.model.data;

import java.sql.Date;

/**
 * Data-class describes Elective course's entity in DB
 */
public class ElectiveCourse {

    /**
     * Entity's fields
     */
    private Long id;
    private Long teacherId;
    private String title;
    private String description;
    private Date startDate;
    private boolean isStarted;

    /**
     * Empty constructor for building object with setters
     */
    public ElectiveCourse() {
    }

    /**
     * Constructor with all fields
     */
    public ElectiveCourse(Long id, Long teacherId, String title, String description) {
        this.id = id;
        this.teacherId = teacherId;
        this.title = title;
        this.description = description;
    }

    /**
     * Getters and Setters of class's fields
     */
    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
