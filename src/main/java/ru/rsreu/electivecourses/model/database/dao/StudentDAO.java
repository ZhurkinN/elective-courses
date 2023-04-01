package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.dto.AdvertisementDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.StudentReportDTO;

import java.util.List;

/**
 * DAO interface for student's actions
 */
public interface StudentDAO {

    /**
     * Gets info about student's courses by id
     *
     * @param studentId student's id
     * @return list of courses' info
     */
    List<CourseDetailsDTO> getCoursesByStudentId(Long studentId);

    /**
     * Gets available announcements of courses
     *
     * @param studentId student's id
     * @return list of announcements' info
     */
    List<AdvertisementDTO> getAvailableCourses(Long studentId);

    /**
     * Makes student with given id join course
     *
     * @param studentId student's id
     * @param courseId  course's id
     * @return did user join course or not
     */
    boolean joinCourse(Long studentId, Long courseId);

    /**
     * Makes student with given id leave course
     *
     * @param studentId student's id
     * @param courseId  course's id
     * @return did user leave course or not
     */
    boolean leaveCourse(Long studentId, Long courseId);

    /**
     * Gets info about marks on student's courses with given id
     *
     * @param studentId student's id
     * @return list with info about marks on student's courses
     */
    List<StudentReportDTO> getMarksReport(Long studentId);

    /**
     * Gets info about attendance on student's courses with given id
     *
     * @param studentId student's id
     * @return list with info about attendance on student's courses
     */
    List<StudentReportDTO> getAttendanceReport(Long studentId);
}
