<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультативные курсы</title>
</head>
<body>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <form name = "studentPage" method="post" action="FrontController">
        <h1>Информационная система факультативных курсов</h1>
        <h2>${name}, Вы находитесь в системе факультативных курсов! Ваша Роль: Студент.</h2>
        <form>
            <input type="hidden" name="command" value="logout" />
            <input type ="submit" value="Просмотр оценок и посещаемости" />
        </form>
        <form>
            <input type="hidden" name="command" value="logout" />
            <input type ="submit" value="Запись на факультативный курс" />
        </form>
        <form>
            <input type="hidden" name="command" value="logout" />
            <input type ="submit" value="Отчисление с факультативного курса" />
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
