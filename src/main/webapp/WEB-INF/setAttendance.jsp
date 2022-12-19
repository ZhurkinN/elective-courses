<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выставление посещаемости</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <form name = "setAttendancePage" method="post" action="FrontController">
        <h1>
            Выставление посещаемости
        </h1>
        <form>
            <h3>
                Таблица посещаемости
            </h3>
            <table>
                <tr>
                    <th>Название курса</th>
                    <th>ФИО студента</th>
                    <th>Номер занятия</th>
                    <th>Посещаемость</th>
                    <th>Дата занятия</th>
                </tr>
                <c:forEach items="${attendanceList}" var="attendanceDTO" varStatus="loop">
                <tr>
                    <td><c:out value="${attendanceDTO.course.title}" /></td>
                    <td><c:out value="${attendanceDTO.user.surname} ${attendanceDTO.user.name} ${attendanceDTO.user.patronymic}" /></td>
                    <td><c:out value="${attendanceDTO.attendance.lessonNumber}" /></td>
                    <td>
                        <c:if test="${attendanceDTO.attendance.isVisited()}">
                            +
                        </c:if>
                        <c:if test="${!attendanceDTO.attendance.isVisited()}">
                            -
                        </c:if>
                    </td>
                    <td><c:out value="${attendanceDTO.attendance.attendanceDate}" /></td>
                </tr>
                </c:forEach>
            </table>
        </form>
        <form>
            <h3>
                Выставление посещаемости
            </h3>
            <table>
                <tr>
                    <th>Название курса</th>
                    <th>ФИО студента</th>
                    <th>Выставление посещаемости</th>
                </tr>
                <c:forEach items="${userList}" var="user" varStatus="loop">
                    <form name = "setAttentionForm" method="post" action="FrontController">
                        <tr>
                            <td><c:out value="${user.course.title}" /></td>
                            <td><c:out value="${user.user.surname} ${user.user.name} ${user.user.patronymic}" /></td>
                            <td style="display-inside: ruby-base">
                                <input type="radio" id="attendance1" name="attendance" value="1" />
                                <label style="display: inline; margin-bottom: 3px" for="attendance1">
                                    Присутствовал
                                </label><br>
                                <input type="radio" id="attendance2" name="attendance" value="0" />
                                <label style="display: inline; margin-bottom: 3px" for="attendance2">
                                    Отсутствовал
                                </label><br>
                                <input type="hidden" name="courseId" value=${user.details.courseId} />
                                <input type="hidden" name="studentId" value=${user.details.studentId} />
                                <input type="hidden" name="command" value="setAttendance" />
                                <input style="width: 75%" type ="submit" value="Выставить посещаемость" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </form>
    </form>
    <form>
        <input type="hidden" name="command" value="returnToMain" />
        <input type ="submit" value="Вернуться на главную" />
        <p class="text">${result}</p>
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
