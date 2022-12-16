<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание объявления о курсе</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <form name = "createCoursePage" method="post" action="FrontController">
        <h1>Создание объявления о курсе</h1>
        <form>
            <h3>Список объявлений о курсах</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Название</th>
                    <th>Описание</th>
                </tr>
                <c:forEach items="${notStartedCoursesList}" var="course" varStatus="loop">
                    <tr>
                        <td><c:out value="${course.id}" /></td>
                        <td><c:out value="${course.title}" /></td>
                        <td><c:out value="${course.description}" /></td>
                    </tr>
                </c:forEach>
            </table>
            <label>Название:
                <input required type="text" name="title" value="" placeholder="Введите название" />
            </label>
            <label>Описание:
                <input required type="text" name="description" value="" placeholder="Введите описание" />
            </label>
            <input type="hidden" name="command" value="createNewCourse" />
            <input type ="submit" value="Создать объявление" />
        </form>
        <form>
            <input type="hidden" name="command" value="returnToMain" />
            <input type ="submit" value="Вернуться на главную" />
            <p class="text">${result}</p>
        </form>
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
