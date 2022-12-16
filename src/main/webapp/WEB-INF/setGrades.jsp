<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выставление оценок</title>
</head>
<body>
  <style><%@include file="/WEB-INF/css/main.css"%></style>
  <form name = "setGradesPage" method="post" action="FrontController">
    <h1>Создание объявления о курсе</h1>
    <form>
      <h3>Таблица итоговых оценок за все курсы</h3>
      <table>
        <tr>
          <th>ID курса</th>
          <th>Название курса</th>
          <th>Фамилия</th>
          <th>Имя</th>
          <th>Итоговая оценка</th>
        </tr>
        <c:forEach items="${detailsList}" var="detail" varStatus="loop">
          <form name = "setFinalGradeForm" method="post" action="FrontController">
            <tr>
              <td><c:out value="${detail.course.id}" /></td>
              <td><c:out value="${detail.course.title}" /></td>
              <td><c:out value="${detail.user.surname}" /></td>
              <td><c:out value="${detail.user.name}" /></td>
              <td style="display-inside: ruby-base">
                <c:choose>
                  <c:when test="${detail.details.finalMark == 'Нет оценки'}">
                    <input type="radio" id="mark1" name="mark" value="Зачтено" />
                    <label style="display: inline; margin-bottom: 3px" for="mark1">
                      Зачтено
                    </label><br>
                    <input type="radio" id="mark2" name="mark" value="Не зачтено" />
                    <label style="display: inline; margin-bottom: 3px" for="mark2">
                      Не зачтено
                    </label><br>
                    <input type="radio" id="mark3" name="mark" value="Отчислен" />
                    <label style="display: inline; margin-bottom: 3px" for="mark3">
                      Отчислен
                    </label><br>
                    <input type="hidden" name="studentId" value=${detail.details.studentId} />
                    <input type="hidden" name="courseId" value=${detail.course.id} />
                    <input type="hidden" name="command" value="setFinalGrade" />
                    <input style="width: 75%" type ="submit" value="Выставить оценку" />
                  </c:when>
                  <c:otherwise>
                    ${detail.details.finalMark}
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
          </form>
        </c:forEach>
      </table>
    </form>
  </form>
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
