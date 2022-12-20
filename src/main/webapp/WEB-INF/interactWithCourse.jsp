<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Запись/Отчисление</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <form name = "interactWithCoursePage" method="post" action="FrontController">
        <h1>Управление Вашими курсами</h1>
        <form>
            <h3>
                Ваши действующие курсы
            </h3>
            <table>
                <tr>
                    <th>Название курса</th>
                    <th>ФИО преподавателя</th>
                    <th>Дата начала курса</th>
                    <th>Описание</th>
                    <th>Оценка</th>
                    <th>Действие</th>
                </tr>
                <c:forEach items="${currentCoursesList}" var="course" varStatus="loop">
                    <form name = "leaveCourseForm" method="post" action="FrontController">
                        <tr>
                            <td><c:out value="${course.course.title}" /></td>
                            <td><c:out value="${course.user.surname} ${course.user.name} ${course.user.patronymic}" /></td>
                            <td><c:out value="${course.course.startDate}" /></td>
                            <td><c:out value="${course.course.description}" /></td>
                            <td><c:out value="${course.details.finalMark}" /></td>
                            <td>
                                <c:choose>
                                    <c:when test="${!course.details.finalMark == 'Нет оценки'}">
                                        <hr style="width:50%">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="hidden" name="command" value="leaveCourse" />
                                        <input type="hidden" name="course" value=${course.course.id} />
                                        <input style="width: 85%" type="submit" value="Отчислиться" />
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </form>
        <form>
            <h3>
                Доступные объявления о курсах
            </h3>
            <table>
                <tr>
                    <th>Название курса</th>
                    <th>ФИО преподавателя</th>
                    <th>Описание</th>
                    <th>Запись</th>
                </tr>
                <c:forEach items="${advertisementList}" var="advertisement" varStatus="loop">
                    <form name = "joinCourseForm" method="post" action="FrontController">
                        <tr>
                            <td><c:out value="${advertisement.course.title}" /></td>
                            <td><c:out value="${advertisement.teacher.surname} ${advertisement.teacher.name} ${advertisement.teacher.patronymic}" /></td>
                            <td><c:out value="${advertisement.course.description}" /></td>
                            <td>
                                <input type="hidden" name="command" value="joinCourse" />
                                <input type="hidden" name="courseId" value=${advertisement.course.id} />
                                <input style="width: 75%" type="submit" value="Записаться" />
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
