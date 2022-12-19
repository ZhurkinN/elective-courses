package ru.rsreu.electivecourses.model.data.dto;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.User;

public class AdvertisementDTO {

    private User teacher;
    private ElectiveCourse course;

    public AdvertisementDTO() {
    }

    public AdvertisementDTO(User teacher, ElectiveCourse course) {
        this.teacher = teacher;
        this.course = course;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public ElectiveCourse getCourse() {
        return course;
    }

    public void setCourse(ElectiveCourse course) {
        this.course = course;
    }
}
