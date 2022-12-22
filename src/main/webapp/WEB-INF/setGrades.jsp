<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выставление оценок</title>
</head>
<body>
  <style><%@include file="/css/main.css"%></style>
  <form name = "setGradesPage" method="post" action="FrontController">
    <h1>
      Выставление оценок
    </h1>
    <form>
      <h3>
        Таблица итоговых оценок за все курсы
      </h3>
      <table>
        <tr>
          <th>Название курса</th>
          <th>ФИО студента</th>
          <th>Итоговая оценка</th>
        </tr>
        <c:forEach items="${detailsList}" var="detail" varStatus="loop">
          <form name = "setFinalGradeForm" method="post" action="FrontController">
            <tr>
              <td><c:out value="${detail.course.title}" /></td>
              <td><c:out value="${detail.user.surname} ${detail.user.name} ${detail.user.patronymic}" /></td>
              <td style="display-inside: ruby-base">
                <c:choose>
                  <c:when test="${!detail.details.isMarked()}">
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
    <form>
      <h3>
        Таблица промежуточных оценок
      </h3>
      <table>
        <tr>
          <th>Название курса</th>
          <th>ФИО студента</th>
          <th>Оценка</th>
          <th>Дата выставления</th>
        </tr>
        <c:forEach items="${marksList}" var="grade" varStatus="loop">
            <tr>
              <td><c:out value="${grade.course.title}" /></td>
              <td><c:out value="${grade.user.surname} ${grade.user.name} ${grade.user.patronymic}" /></td>
              <td><c:out value="${grade.mark.mark}" /></td>
              <td><c:out value="${grade.mark.markDate}" /></td>
            </tr>
          </form>
        </c:forEach>
      </table>
      <h3>
        Выставление промежуточных оценок
      </h3>
      <table>
        <tr>
          <th>Название курса</th>
          <th>ФИО студента</th>
          <th>Выставление оценки</th>
        </tr>
        <c:forEach items="${setMarksList}" var="user" varStatus="loop">
          <form name = "setIntermediateMarksForm" method="post" action="FrontController">
            <tr>
              <td><c:out value="${user.course.title}" /></td>
              <td><c:out value="${user.user.surname} ${user.user.name} ${user.user.patronymic}" /></td>
              <td style="display-inside: ruby-base">
                <input type="radio" id="intermediateMark1" name="intermediateMark" value="5" />
                <label style="display: inline; margin-bottom: 3px" for="intermediateMark1">
                  5
                </label><br>
                <input type="radio" id="intermediateMark2" name="intermediateMark" value="4" />
                <label style="display: inline; margin-bottom: 3px" for="intermediateMark2">
                  4
                </label><br>
                <input type="radio" id="intermediateMark3" name="intermediateMark" value="3" />
                <label style="display: inline; margin-bottom: 3px" for="intermediateMark3">
                  3
                </label><br>
                <input type="radio" id="intermediateMark4" name="intermediateMark" value="2" />
                <label style="display: inline; margin-bottom: 3px" for="intermediateMark4">
                  2
                </label><br>
                <input type="hidden" name="courseId" value=${user.details.courseId} />
                <input type="hidden" name="studentId" value=${user.details.studentId} />
                <input type="hidden" name="command" value="setIntermediateGrade" />
                <input style="width: 75%" type ="submit" value="Выставить оценку" />
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
