<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультативные курсы</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <form name = "studentPage" method="post" action="FrontController">
        <h1>Информационная система факультативных курсов</h1>
        <h2>${name}, Вы находитесь в системе факультативных курсов! Ваша Роль: Администратор.</h2>
        <h3>Список авторизованных пользователей</h3>
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
        <form>
            <input type="hidden" name="command" value="showRegistrationNewUser" />
            <input type ="submit" value="Регистрация пользователей" />
        </form>
        <form>
            <input type="hidden" name="command" value="showEditingUser" />
            <input type ="submit" value="Редактирование пользователей" />
        </form>
        <form>
            <input type="hidden" name="command" value="showDeletingUser" />
            <input type ="submit" value="Удаление пользователей" />
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
