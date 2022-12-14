<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <form name = "userList" method="post" action="FrontController">
        <h1>${title}</h1>
        <form>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                    <th>Роль</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Отчество</th>
                    <th>Авторизован</th>
                    <th>Действителен</th>
                </tr>
                <c:forEach items="${usersList}" var="user" varStatus="loop">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.login}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        <td><c:out value="${user.roleId}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.surname}" /></td>
                        <td><c:out value="${user.patronymic}" /></td>
                        <td><c:out value="${user.isAuthorized()}"  /></td>
                        <td><c:out value="${user.isActive()}" /></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name="command" value="returnToMain" />
            <input type ="submit" value="Вернуться на главную" />
        </form>
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
