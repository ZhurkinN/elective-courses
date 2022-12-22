package ru.rsreu.electivecourses.model.data;

public class CourseDetails {

    private Long courseId;
    private Long studentId;
    private String finalMark;
    private boolean isMarked;

    public CourseDetails() {
    }

    public CourseDetails(Long courseId, Long studentId, String finalMark, boolean isMarked) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.finalMark = finalMark;
        this.isMarked = isMarked;
    }

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
