package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;

import java.util.List;

public interface TeacherDAO {

    List<ElectiveCourse> getStartedCoursesByTeacherId(Long teacherId);
    List<ElectiveCourse> getNotStartedCoursesByTeacherId(Long teacherId);
    boolean startCourse(Long courseId);
}
