<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductList</title>
</head>
<body>
<dif>
    <h1>Все товары магазина</h1>
    <form:form method="POST" modelAttribute="product">
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
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.comment}</td>
                <td>${product.price}</td>
                <td>${product.cateroty}</td>
                <td>${product.county}</td>
                <td><form:input path="county" type="text" name="country_editProduct" value="кол-во"/></td>
                <td colspan="2"><input type="submit" value="Добавить в корзину"/></td>
            </tr>
        </table>
    </form:form>
</dif>
</body>
</html>
