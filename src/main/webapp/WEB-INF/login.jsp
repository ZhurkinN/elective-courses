<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Авторизация в системе</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/login.css"%></style>
    <form name = "loginForm" method="post" action="controller/FrontController">
        <input type="hidden" name="command" value="login" />
        <h1>Авторизация в системе факультативных курсов</h1>
        <label>Логин:
            <input required type="text" name="login" value="" placeholder="Введите логин" />
        </label>
        <label>Пароль:
            <input required type="password" name="password" value="" placeholder="Введите пароль" />
        </label>
        <input type ="submit" value="Авторизоваться">
    </form>
    <footer>
        <p>Выполнили студенты группы 0413 Журкин Н.С. и Ципиньо Д.В.</p>
    </footer>
</body>
</html>
