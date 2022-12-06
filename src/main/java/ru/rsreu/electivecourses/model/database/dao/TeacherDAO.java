package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;

import java.util.List;

public interface TeacherDAO {

    List<ElectiveCourse> getCoursesByTeacherId(Long teacherId);
}
