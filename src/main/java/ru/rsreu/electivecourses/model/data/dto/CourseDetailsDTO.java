package ru.rsreu.electivecourses.model.data.dto;

import ru.rsreu.electivecourses.model.data.CourseDetails;
import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;
import ru.rsreu.electivecourses.model.database.dao.UserDAO;

public class CourseDetailsDTO {

    private User user;
    private ElectiveCourse course;
    private CourseDetails details;

    public CourseDetailsDTO() {
    }

    public CourseDetailsDTO(User user, ElectiveCourse course, CourseDetails details) {
        this.user = user;
        this.course = course;
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ElectiveCourse getCourse() {
        return course;
    }

    public void setCourse(ElectiveCourse course) {
        this.course = course;
    }

    public CourseDetails getDetails() {
        return details;
    }

    public void setDetails(CourseDetails details) {
        this.details = details;
    }

}
