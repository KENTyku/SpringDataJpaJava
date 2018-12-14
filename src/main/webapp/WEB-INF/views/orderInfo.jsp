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
    <title>Информация о заказе</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div>
    <h1>Заказ</h1>
    <table border="1">
        <tr>
            <td><b>id продукта</b></td>
            <td><b>Наименование</b></td>
            <td><b>Количество</b></td>
        </tr>
        <c:forEach var="orderPosition" items="${orderPositionList}">
            <tr>
                <td>${orderPosition.id.product.id}</td>
                <td>${orderPosition.id.product.name}</td>
                <td>${orderPosition.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
