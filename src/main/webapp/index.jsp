<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Добро пожаловать в информационную систему факультативных курсов!" %>
</h1>
<jsp:forward page="WEB-INF/login.jsp"></jsp:forward>
</body>
</html>