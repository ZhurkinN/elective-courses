<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление пользователя</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <div>
        <h1>Удаление пользователя</h1>
        <h2>Все пользователи</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Логин</th>
                <th>Пароль</th>
                <th>Роль</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Удаление</th>
            </tr>
            <c:forEach items="${usersList}" var="user" varStatus="loop">
                <form name = "deleteUserForm" method="post" action="FrontController">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.login}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        <td><c:out value="${user.roleId}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.surname}" /></td>
                        <td><c:out value="${user.patronymic}" /></td>
                        <td>
                            <input type="hidden" name="command" value="deleteUser" />
                            <input type="hidden" name="delete" value=${user.id} />
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
