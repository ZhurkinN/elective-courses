package ru.rsreu.electivecourses.model.data.enums;

public class Attendance {

    private Long id;
    private Long courseId;
    private Long studentId;
    private Integer lessonNumber;
    private boolean isVisited;

    private Attendance() {
    }

    public Attendance(Long id, Long courseId, Long studentId, Integer lessonNumber, boolean isVisited) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.lessonNumber = lessonNumber;
        this.isVisited = isVisited;
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
