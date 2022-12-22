package ru.rsreu.electivecourses.model.database.dao;

import ru.rsreu.electivecourses.model.data.ElectiveCourse;
import ru.rsreu.electivecourses.model.data.dto.AttendanceDTO;
import ru.rsreu.electivecourses.model.data.dto.CourseDetailsDTO;
import ru.rsreu.electivecourses.model.data.dto.IntermediateMarksDTO;

import java.util.List;

/**
 * DAO interface for teacher's actions
 */
public interface TeacherDAO {

    /**
     * Gets already started courses if teacher with given teacher's id
     * @param teacherId teacher's id
     * @return list of started courses
     */
    List<ElectiveCourse> getStartedCoursesByTeacherId(Long teacherId);

    /**
     * Gets not started courses of teacher with given teacher's id
     * @param teacherId teacher's id
     * @return list of not started courses
     */
    List<ElectiveCourse> getNotStartedCoursesByTeacherId(Long teacherId);

    /**
     * Starts course with given id
     * @param courseId course's id
     * @return was course started or not
     */
    boolean startCourse(Long courseId);

    /**
     * Creates announcement about course
     * @param id teacher's id
     * @param title course's title
     * @param description course's description
     * @return was course created or not
     */
    boolean createCourse(Long id, String title, String description);

    /**
     * Gets detailed info about courses of teacher with given teacher's id
     * @param teacherId teacher's id
     * @return detailed info list
     */
    List<CourseDetailsDTO> getCourseDetailsInfoByTeacherId(Long teacherId);

    /**
     * Sets final mark
     * @param studentId student's id
     * @param courseId course's id
     * @param finalMark mark
     * @return was mark set or not
     */
    boolean setFinalMark(Long studentId, Long courseId, String finalMark);

    /**
     * Gets info about intermediate marks on courses of teacher with given teacher's id
     * @param teacherId teacher's id
     * @return intermediate marks info list
     */
    List<IntermediateMarksDTO> getIntermediateMarksInfoByTeacherId(Long teacherId);

    /**
     * Gets detailed info about students on course with given teacher's id
     * @param teacherId teacher's id
     * @return detailed info list
     */
    List<CourseDetailsDTO> getCourseParticipantsByTeacherId(Long teacherId);

    /**
     * Sets intermediate mark
     * @param studentId student's id
     * @param courseId course's id
     * @param mark intermediate mark
     * @return was mark set or not
     */
    boolean setIntermediateMark(Long courseId, Long studentId, Integer mark);

    /**
     * Gets info about attendance on courses of teacher with given id
     * @param teacherId teacher's id
     * @return attendance info list
     */
    List<AttendanceDTO> getAttendanceInfoByTeacherId(Long teacherId);

    /**
     * Sets attendance
     * @param studentId student's id
     * @param courseId course's id
     * @param attendance attendance info
     * @param newAttendanceNumber class number
     * @return was attendance set or not
     */
    boolean setAttendance(Long courseId, Long studentId, Integer attendance, Integer newAttendanceNumber);

    /**
     * Gets number of last class
     * @param studentId student's id
     * @param courseId course's id
     * @return number of last class
     */
    Integer getLastAttendanceNumber(Long studentId, Long courseId);
}
