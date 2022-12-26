<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Модерирование пользователей</title>
</head>
<body>
    <style><%@include file="/css/main.css"%></style>
    <div>
        <h1>Блокировка/Разблокировка пользователей</h1>
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
                <th>Действителен</th>
                <th>Действие</th>
            </tr>
            <c:forEach items="${usersList}" var="user" varStatus="loop">
                <form name = "blockUserForm" method="post" action="FrontController">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.login}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        <td><c:out value="${user.roleId}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.surname}" /></td>
                        <td><c:out value="${user.patronymic}" /></td>
                        <td>
                            <c:if test="${user.isActive()}">
                                Действителен
                            </c:if>
                            <c:if test="${!user.isActive()}">
                                Заблокирован
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${user.isActive()}">
                                <input type="hidden" name="command" value="blockUser" />
                                <input type="hidden" name="block" value=${user.id} />
                                <input style="width: 75%" type="submit" value="Заблокировать" />
                            </c:if>
                            <c:if test="${!user.isActive()}">
                                <input type="hidden" name="command" value="unblockUser" />
                                <input type="hidden" name="unblock" value=${user.id} />
                                <input style="width: 75%" type="submit" value="Разблокировать" />
                            </c:if>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
    <form>
        <input type="hidden" name="command" value="returnToMain" />
        <input type="submit" value="Вернуться на главную" />
        <p class="text">${result}</p>
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
