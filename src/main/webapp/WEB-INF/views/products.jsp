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
    <title>ProductList</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div>
    <h3>Каталог товаров</h3>
    <a href="editProduct?id=new">Добавить товар</a><br>
    <table border="1">
        <tr>
            <td><b>id товара:</b></td>
            <td><b>Наименование:</b></td>
            <td><b>Описание:</b></td>
            <td><b>Изображение:</b></td>
            <td><b>Цена:</b></td>
            <td><b>Категория:</b></td>
            <td><b>Производитель:</b></td>
            <td><b>Количество</b></td>
            <td><b>Добавить в корзину</b></td>
        </tr>
        <c:forEach var="product" items="${productList}">
            <form:form method="post" action="addProductToCart">
                <input name="productId" type="hidden" value="${product.id}" id="productId_Products"/>
                <tr>
                    <td>${product.id}</td>
                    <td><a href="editProduct?id=${product.id}">${product.name}</a></td>
                    <td>${product.comment}</td>
                    <td><img src="/resources/${product.imageUrl}" alt="image" width="100"  height="100"></td>
                    <%--<td><img src="/resources/sun.png" alt="image"></td>--%>
                    <td>${product.price}</td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.country.name}</td>
                    <td><input name="quantity" type="text" id="quantity_Products" value="0"/></td>
                    <td colspan="1"><input type="submit" value="Добавить в корзину"/></td>
                </tr>
            </form:form>
        </c:forEach>
    </table>
</div>
</body>
</html>
