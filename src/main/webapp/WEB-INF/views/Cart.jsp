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
    <h1>Корзина</h1>
    <table border="1">
        <tr>
            <td><b>id товара:</b></td>
            <td><b>Наименование:</b></td>
            <td><b>Описание:</b></td>
            <td><b>Цена:</b></td>
            <td><b>Категория:</b></td>
            <td><b>Производитель:</b></td>
            <td><b>Количество</b></td>
            <td><b>Пересчитать:</b></td>
            <td><b>Удалить:</b></td>
        </tr>
        <c:forEach var="position" items="${positions}">
            <form:form method="post" action="editCartProduct">
                <input name="productId" type="hidden" value="${position.value.product.id}" id="productId_Products"/>
                <tr>
                    <td>${position.value.product.id}</td>
                    <td>${position.value.product.name}</td>
                    <td>${position.value.product.comment}</td>
                    <td>${position.value.product.price}</td>
                    <td>${position.value.product.category.categoryName}</td>
                    <td>${position.value.product.country.name}</td>
                    <td><input name="quantity" type="text" id="quantity_Products" value="${position.value.quantity}"/>
                    </td>
                    <td><a href="deleteCartProduct?productId=${position.value.product.id}">Удалить</a></td>
                    <td colspan="1"><input type="submit" value="Пересчитать"/></td>
                </tr>
            </form:form>
        </c:forEach>
    </table>
</div>
<div>
    <a href="saveOrder">Заказать</a><br>
</div>
</body>
</html>
