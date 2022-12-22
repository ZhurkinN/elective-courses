<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление курсов</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <div>
        <h1>Удаление курсов</h1>
        <h2>Все курсы</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>ID преподавателя</th>
                <th>Название</th>
                <th>Описание</th>
                <th>Стартовал</th>
                <th>Дата начала</th>
                <th>Действие</th>
            </tr>
            <c:forEach items="${coursesList}" var="course" varStatus="loop">
                <form name = "deleteCourseForm" method="post" action="FrontController">
                    <tr>
                        <td><c:out value="${course.id}" /></td>
                        <td><c:out value="${course.teacherId}" /></td>
                        <td><c:out value="${course.title}" /></td>
                        <td><c:out value="${course.description}" /></td>
                        <td>
                            <c:if test="${course.isStarted()}">
                                +
                            </c:if>
                            <c:if test="${!course.isStarted()}">
                                -
                            </c:if>
                        </td>
                        <td><c:out value="${course.startDate}" /></td>
                        <td>
                            <input type="hidden" name="command" value="deleteCourse" />
                            <input type="hidden" name="delete" value=${course.id} />
                            <input style="width: 75%" type="submit" value="Удалить" />
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
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
