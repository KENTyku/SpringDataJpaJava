<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart</title>
</head>
<body>
<jsp:include page="Menu.jsp"/>
<div>
    <h1>Список заказов</h1>
    <table border="1">
        <tr>
            <td><b>id заказа</b></td>
            <td><b>Дата:</b></td>
            <td><b>Просмотреть:</b></td>
            <%--<td><b>Удалить:</b></td>--%>
        </tr>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.id}</td>
                <td>${order.date}</td>
                <td><a href="orderInfo?id=${order.id}">Просмотреть</a></td>
                <%--<td><a href="deleteOrder?orderId=${order.id}">Удалить</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
