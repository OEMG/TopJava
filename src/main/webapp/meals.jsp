<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.javawebinar.topjava.util.DateTimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<section>
    <a href="">Add Meal</a>
    <p>
    <table>
        <tr>
            <th>Дата/Время</th>
            <th>Описание</th>
            <th>Калории</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="meal" items="${meals}">
            <tr class="<c:choose>
                          <c:when test='${meal.excess}'>excess</c:when>
                          <c:otherwise>normal</c:otherwise>
                       </c:choose>">
                <td>${DateTimeUtil.formatDateTime(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="">Update</a></td>
                <td><a href="">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>