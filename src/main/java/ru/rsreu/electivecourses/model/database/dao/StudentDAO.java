package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.StudentReportDTO;

import java.util.List;

public interface StudentDAO {

    List<CourseDetailsDTO> getCoursesByStudentId(Long studentId);

    List<AdvertisementDTO> getAvailableCourses(Long studentId);

    boolean joinCourse(Long studentId, Long courseId);

    boolean leaveCourse(Long studentId, Long courseId);

    List<StudentReportDTO> getMarksReport(Long studentId);

    List<StudentReportDTO> getAttendanceReport(Long studentId);
}
