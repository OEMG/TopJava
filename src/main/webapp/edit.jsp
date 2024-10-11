<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.javawebinar.topjava.util.DateTimeUtil" %>
<html>
<head>
    <title>Edit Meal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<section>
    <h1>Edit meal</h1>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <form action="meals" method="post">
        <input type="hidden" name="id" value="${meal.id}">
        <table>
            <tr>
                <td><label for="dateTime">Date/Time:</label></td>
                <td><input type="datetime-local" id="dateTime" name="dateTime"
                           value="${meal.dateTime}"></td>
            </tr>
            <tr>
                <td><label for="description">Description:</label></td>
                <td><input type="text" id="description" name="description"
                           value="${meal.description}"></td>
            </tr>
            <tr>
                <td><label for="calories">Calories:</label></td>
                <td><input type="number" id="calories" name="calories"
                           value="${meal.calories}"></td>
            </tr>
        </table>
        <br>
        <button type="submit">Сохранить</button>
        <button type="button" onclick="window.history.back()">Отменить</button>
    </form>
</section>
</body>
</html>
