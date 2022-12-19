package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;

import java.util.List;

public interface StudentDAO {

    List<CourseDetailsDTO> getCoursesByStudentId(Long studentId);

    List<AdvertisementDTO> getAvailableCourses(Long studentId);

    boolean joinCourse(Long studentId, Long courseId);

    boolean leaveCourse(Long studentId, Long courseId);
}
