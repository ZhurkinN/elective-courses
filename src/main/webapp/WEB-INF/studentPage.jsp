<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультативные курсы</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <form name = "studentPage" method="post" action="FrontController">
        <h1>Информационная система факультативных курсов</h1>
        <h2>${name}, Вы находитесь в системе факультативных курсов! Ваша Роль: Студент.</h2>
        <h3>
            Оценки на Ваших курсах
        </h3>
        <table>
            <tr>
                <th>Название курса</th>
                <th>ФИО студента</th>
                <th>ФИО преподавателя</th>
                <th>Оценка</th>
                <th>Дата выставления</th>
            </tr>
            <c:forEach items="${marksInfoList}" var="markReport" varStatus="loop">
                <tr>
                    <td><c:out value="${markReport.course.title}" /></td>
                    <td><c:out value="${markReport.student.surname} ${markReport.student.name} ${markReport.student.patronymic}" /></td>
                    <td><c:out value="${markReport.teacher.surname} ${markReport.teacher.name} ${markReport.teacher.patronymic}" /></td>
                    <td><c:out value="${markReport.mark.mark}" /></td>
                    <td><c:out value="${markReport.mark.markDate}" /></td>
                </tr>
            </c:forEach>
        </table>
        <h3>
            Посещаемость на Ваших курсах
        </h3>
        <table>
            <tr>
                <th>Название курса</th>
                <th>ФИО студента</th>
                <th>ФИО преподавателя</th>
                <th>Номер занятия</th>
                <th>Посещаемость</th>
                <th>Дата занятия</th>
            </tr>
            <c:forEach items="${attendanceInfoList}" var="attendanceReport" varStatus="loop">
                <tr>
                    <td><c:out value="${attendanceReport.course.title}" /></td>
                    <td><c:out value="${attendanceReport.student.surname} ${attendanceReport.student.name} ${attendanceReport.student.patronymic}" /></td>
                    <td><c:out value="${attendanceReport.teacher.surname} ${attendanceReport.teacher.name} ${attendanceReport.teacher.patronymic}" /></td>
                    <td><c:out value="${attendanceReport.attendance.lessonNumber}" /></td>
                    <td>
                        <c:if test="${attendanceReport.attendance.isVisited()}">
                            +
                        </c:if>
                        <c:if test="${!attendanceReport.attendance.isVisited()}">
                            -
                        </c:if>
                    </td>
                    <td><c:out value="${attendanceReport.attendance.attendanceDate}" /></td>
                </tr>
            </c:forEach>
        </table>
        <form>
            <input type="hidden" name="command" value="showCourseInteractions" />
            <input type ="submit" value="Запись/Отчисление с курсов" />
        </form>
        <form>
            <input type="hidden" name="command" value="logout" />
            <input type ="submit" value="Выход из системы" />
        </form>
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
