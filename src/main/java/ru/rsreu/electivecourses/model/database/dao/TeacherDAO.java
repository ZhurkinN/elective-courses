package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;

import java.util.List;

public interface TeacherDAO {

    List<ElectiveCourse> getStartedCoursesByTeacherId(Long teacherId);
    List<ElectiveCourse> getNotStartedCoursesByTeacherId(Long teacherId);
    boolean startCourse(Long courseId);
    boolean createCourse(Long id, String title, String description);
    List<CourseDetailsDTO> getCourseDetailsInfoByTeacherId(Long teacherId);
    boolean setFinalMark(Long studentId, Long courseId, String finalMark);
}
