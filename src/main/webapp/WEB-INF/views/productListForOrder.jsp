<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>ProductList</title>
</head>
<body>
<dif>
    <h1>Все товары магазина</h1>
    <%--<form:form method="POST" modelAttribute="product">--%>

        <table border="1">
            <tr>
                <td><b>id товара:</b></td>
                <td><b>Наименование:</b></td>
                <td><b>Описание:</b></td>
                <td><b>Цена:</b></td>
                <td><b>Категория:</b></td>
                <td><b>Производитель:</b></td>
                <td><b>Количество</b></td>
                <td><b>Добавить в корзину</b></td>
            </tr>
            <c:forEach var="product" items="${productList}">
                <%--@elvariable id="orderModel" type=""--%>
                <form:form method="POST" modelAttribute="orderModel" action="listOrder">
                    <form:input path="idProduct" type="hidden" value="${product.id}" id="productId_productListForOrder"/>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.comment}</td>
                    <td>${product.price}</td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.country.name}</td>
                    <td><form:input path="quantity" type="text" id="quantity_productListForOrder"
                                    value="Кол-во"/></td>
                    <td colspan="2"><input type="submit" value="Добавить в корзину"/></td>
                </tr>
                <%--<form:input path=""--%>
                </form:form>
            </c:forEach>
        </table>

</dif>
<dif>
    <a href="listOrder">Корзина</a><br>
    <a href="home">На главную</a><br>
</dif>
</body>
</html>
