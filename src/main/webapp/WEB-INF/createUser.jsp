<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание пользователей</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <form name = "createUser" method="post" action="FrontController">
        <h1>Создание пользователей</h1>
        <form>
            <h2>Список всех пользователей</h2>
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
                        <td>
                            <c:if test="${user.isAuthorized()}">
                                Авторизован
                            </c:if>
                            <c:if test="${!user.isAuthorized()}">
                                Не авторизован
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${user.isActive()}">
                                Действующий
                            </c:if>
                            <c:if test="${!user.isActive()}">
                                Заблокирован
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <label>Логин:
                <input required type="text" name="login" value="" placeholder="Введите логин" />
            </label>
            <label>Пароль:
                <input required type="text" name="password" value="" placeholder="Введите пароль" />
            </label>
            <label>
                <input type="radio" id="roleChoice1" name="role" value="1">
                <label style="display: inline" for="roleChoice1">Администратор</label>
                <input type="radio" id="roleChoice2" name="role" value="2">
                <label style="display: inline" for="roleChoice2">Модератор</label>
                <input type="radio" id="roleChoice3" name="role" value="3">
                <label style="display: inline" for="roleChoice3">Преподаватель</label>
                <input type="radio" id="roleChoice4" name="role" value="4">
                <label style="display: inline" for="roleChoice4">Студент</label>
            </label>
            <label>Имя:
                <input required type="text" name="name" value="" placeholder="Введите имя" />
            </label>
            <label>Фамилия:
                <input required type="text" name="surname" value="" placeholder="Введите фамилию" />
            </label>
            <label>Отчество:
                <input required type="text" name="patronymic" value="" placeholder="Введите отчество" />
            </label>
            <input type="hidden" name="command" value="createNewUser" />
            <input type ="submit" value="Создать пользователя" />
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
