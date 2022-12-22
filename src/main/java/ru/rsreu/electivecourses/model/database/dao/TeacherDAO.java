package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.dto.AttendanceDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.IntermediateMarksDTO;

import java.util.List;

public interface TeacherDAO {

    List<ElectiveCourse> getStartedCoursesByTeacherId(Long teacherId);

    List<ElectiveCourse> getNotStartedCoursesByTeacherId(Long teacherId);

    boolean startCourse(Long courseId);

    boolean createCourse(Long id, String title, String description);

    List<CourseDetailsDTO> getCourseDetailsInfoByTeacherId(Long teacherId);

    boolean setFinalMark(Long studentId, Long courseId, String finalMark);

    List<IntermediateMarksDTO> getIntermediateMarksInfoByTeacherId(Long teacherId);

    List<CourseDetailsDTO> getCourseParticipantsByTeacherId(Long teacherId);

    boolean setIntermediateMark(Long courseId, Long studentId, Integer mark);

    List<AttendanceDTO> getAttendanceInfoByTeacherId(Long teacherId);

    boolean setAttendance(Long courseId, Long studentId, Integer attendance, Integer newAttendanceNumber);

    Integer getLastAttendanceNumber(Long studentId, Long courseId);
}
