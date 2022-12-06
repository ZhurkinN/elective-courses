package ru.rsreu.electivecourses.model.data;

public class ElectiveCourse {

    private Long id;
    private Long teacherId;
    private String title;
    private String description;

    public ElectiveCourse() {
    }

    public ElectiveCourse(Long id, Long teacherId, String title, String description) {
        this.id = id;
        this.teacherId = teacherId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
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
