package ru.rsreu.electivecourses.model.data.dto;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.IntermediateMark;
import ru.rsreu.electivecourses.model.data.User;

public class IntermediateMarksDTO {

    private IntermediateMark mark;
    private ElectiveCourse course;
    private User user;

    public IntermediateMarksDTO() {
    }

    public IntermediateMarksDTO(IntermediateMark mark, ElectiveCourse course, User user) {
        this.mark = mark;
        this.course = course;
        this.user = user;
    }

    public IntermediateMark getMark() {
        return mark;
    }

    public void setMark(IntermediateMark mark) {
        this.mark = mark;
    }

    public ElectiveCourse getCourse() {
        return course;
    }

    public void setCourse(ElectiveCourse course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
