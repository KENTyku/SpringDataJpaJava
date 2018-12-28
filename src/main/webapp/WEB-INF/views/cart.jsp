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
<jsp:include page="menu.jsp"/>
<div>
    <h3>Корзина</h3>
    <table border="1">
        <tr>
            <td><b>id товара:</b></td>
            <td><b>Наименование:</b></td>
            <td><b>Описание:</b></td>
            <td><b>Изображение:</b></td>
            <td><b>Категория:</b></td>
            <td><b>Производитель:</b></td>
            <td><b>Цена:</b></td>
            <td><b>Количество:</b></td>
            <td><b>Стоимость:</b></td>
            <td><b>Пересчитать:</b></td>
            <td><b>Удалить:</b></td>
        </tr>
        <c:forEach var="position" items="${positions}">
            <form:form method="post" action="editCartProduct">
                <input name="productId" type="hidden" value="${position.value.first.id}" id="productId_Products"/>
                <tr>
                    <td>${position.value.first.id}</td>
                    <td>${position.value.first.name}</td>
                    <td>${position.value.first.comment}</td>
                    <td><img src="/resources/${position.value.first.imageUrl}" alt="image" width="100"  height="100></td>
                    <td>${position.value.first.category.categoryName}</td>
                    <td>${position.value.first.country.name}</td>
                    <td>${position.value.first.price}</td>
                    <td><input name="quantity" type="text" id="quantity_Products" value="${position.value.second}"/>
                    </td>
                    <td>${position.value.first.price*position.value.second}</td>
                    <td><a href="deleteCartProduct?productId=${position.value.first.id}">Удалить</a></td>
                    <td colspan="1"><input type="submit" value="Пересчитать"/></td>
                </tr>
            </form:form>
        </c:forEach>
        <tr>
            <td>Итого:</td>
            <td>${cost.cost}</td>
        </tr>
    </table>
</div>
<div>
    <a href="saveOrder">Заказать</a><br>
</div>
</body>
</html>
