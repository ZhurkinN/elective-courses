<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультативные курсы</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <form name = "teacherPage" method="post" action="FrontController">
        <h1>Информационная система факультативных курсов</h1>
        <h2>${name}, Вы находитесь в системе факультативных курсов! Ваша Роль: Преподаватель.</h2>
        <h3>Список объявлений о курсах</h3>
        <table>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Описание</th>
                <th>Действие</th>
            </tr>
            <c:forEach items="${notStartedCoursesList}" var="course" varStatus="loop">
                <form name = "startCourseForm" method="post" action="FrontController">
                    <tr>
                        <td><c:out value="${course.id}" /></td>
                        <td><c:out value="${course.title}" /></td>
                        <td><c:out value="${course.description}" /></td>
                        <td>
                            <input type="hidden" name="command" value="startCourse" />
                            <input type="hidden" name="start" value=${course.id} />
                            <input style="width: 75%" type="submit" value="Начать" />
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        <h3>Список действующих курсов</h3>
        <table>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Описание</th>
                <th>Дата начала</th>
            </tr>
            <c:forEach items="${startedCoursesList}" var="course" varStatus="loop">
                <tr>
                    <td><c:out value="${course.id}" /></td>
                    <td><c:out value="${course.title}" /></td>
                    <td><c:out value="${course.description}" /></td>
                    <td><c:out value="${course.startDate}" /></td>
                </tr>
            </c:forEach>
        </table>
        <form>
            <input type="hidden" name="command" value="showCreatingNewCourse" />
            <input type ="submit" value="Создание объявлений о курсах" />
        </form>
        <form>
            <input type="hidden" name="command" value="showSettingGrades" />
            <input type ="submit" value="Выставление оценок" />
        </form>
        <form>
            <input type="hidden" name="command" value="showCreatingNewCourse" />
            <input type ="submit" value="Отметка посещаемости" />
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