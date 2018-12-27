<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EditProduct</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div>
    <h3>Добавление/Редактирование продукта</h3>
    <form method="POST" action="saveProduct" enctype="multipart/form-data">
        <input name="id" type="hidden" id="id_editProduct" value="${product.id}"/><br>
        <table border="1">
            <tr>
                <td><b>id товара:</b></td>
                <td><b>Наименование:</b></td>
                <td><b>Описание:</b></td>
                <td><b>Изображение:</b></td>
                <td><b>Цена:</b></td>
                <td><b>Категория:</b></td>
                <td><b>Производитель:</b></td>
                <td><b>Действие:</b></td>
            </tr>
            <tr>
                <td>${product.id}</td>
                <td><input name="name" type="text" id="name_editProduct" value="${product.name}"/></td>
                <td><input name="comment" type="text" id="comment_editProduct" value="${product.comment}"/></td>
                <td><input name="image" type="file" id="image_editProduct" accept="image/*"/></td>
                <td><input name="price" type="text" id="price_editProduct" value="${product.price}"/></td>
                <td>
                    <select name="categoryId">
                        <f:forEach items="${categoryList}" var="category">
                            <option name="categoryId" value="${category.id}">
                                <f:out value="${category.categoryName}"/></option>
                        </f:forEach>
                    </select>
                </td>
                <td>
                    <select name="countryId">
                        <f:forEach items="${countryList}" var="country">
                            <option name="countryId" value="${country.id}">
                                <f:out value="${country.name}"/></option>
                        </f:forEach>
                    </select>
                </td>
                <td colspan="2"><input type="submit" value="Добавить/Изменить"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
