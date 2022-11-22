package ru.rsreu.electivecourses.model.data;

public class IntermediateMark {

    private Long id;
    private Long courseId;
    private Long studentId;
    private Integer mark;

    private IntermediateMark() {
    }

    public IntermediateMark(Long id, Long courseId, Long studentId, Integer mark) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.mark = mark;
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
