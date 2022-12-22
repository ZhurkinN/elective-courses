package ru.rsreu.electivecourses.model.data;

/**
 * Data-class describes Course details' entity in DB
 */
public class CourseDetails {

    /**
     * Entity's fields
     */
    private Long courseId;
    private Long studentId;
    private String finalMark;
    private boolean isMarked;

    /**
     * Empty constructor for building object with setters
     */
    public CourseDetails() {
    }

    /**
     * Constructor with all fields
     */
    public CourseDetails(Long courseId, Long studentId, String finalMark, boolean isMarked) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.finalMark = finalMark;
        this.isMarked = isMarked;
    }

    /**
     * Getters and Setters of class's fields
     */
    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
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

}
