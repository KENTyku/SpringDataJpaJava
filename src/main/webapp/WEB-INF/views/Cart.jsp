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
<%--<jsp:include page="/get?id=${snippet.id}"/>--%>
<div>
    <h1>Корзина</h1>
    <%--<a href="editProduct?id=new">Добавить товар</a><br>--%>
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

            <%--<form:input path="orderId" type="hidden" id="orderId_productListForOrder"--%>
            <%--value="${orderModel.orderId}"/>--%>
            <tr>
                <td>${position.value.product.id}</td>
                <td>${position.value.product.name}</td>
                <td>${position.value.product.comment}</td>
                <td>${position.value.product.price}</td>
                <td>${position.value.product.category.categoryName}</td>
                <td>${position.value.product.country.name}</td>
                <form:form method="post" action="editCartProduct">
                    <input name="productId" type="hidden" value="${position.value.product.id}" id="productId_Products"/>
                    <td><input name="quantity" type="text" id="quantity_Products" value="${position.value.quantity}"/>
                    </td>
                    <td colspan="1">
                        <input type="submit" value="Пересчитать"/>
                    </td>
                </form:form>

                <form:form method="get" action="deleteCartProduct">
                    <input name="productId" type="hidden" value="${position.value.product.id}"/>
                    <td colspan="1">
                        <input type="submit" value="Удалить"/>
                    </td>
                </form:form>
            </tr>

        </c:forEach>
    </table>

</div>
<div>
    <a href="order">Заказать</a><br>
</div>
</body>
</html>
