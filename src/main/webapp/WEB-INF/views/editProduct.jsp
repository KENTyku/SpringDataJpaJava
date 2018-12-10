<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EditProduct</title>
</head>
<body>
<dif>
    <h1>Добавить товар в базу или отредактировать имеющийся</h1>
    <form:form method="POST" modelAttribute="product">
        <table border="1">
            <tr>
                <td><b>id товара:</b></td>
                <td><b>Наименование:</b></td>
                <td><b>Описание:</b></td>
                <td><b>Цена:</b></td>
                <td><b>Категория:</b></td>
                <td><b>Производитель:</b></td>
                <td><b>Действие:</b></td>
            </tr>
            <tr>
                <td><form:input path="id" type="text" id="id_editProduct" value="введите id"/></td>
                <td><form:input path="name" type="text" id="name_editProduct" value="наименование"/></td>
                <td><form:input path="comment" type="text" id="comment_editProduct" value="описание"/></td>
                <td><form:input path="price" type="text" id="price_editProduct" value="цена"/></td>
                    <%--<td><form:input path="category" type="text" name="category_editProduct" value="категория"--%>
                    <%--/></td>--%>
                    <%--<td><form:input path="country" type="text" name="country_editProduct" value="Производитель"--%>
                    <%--/></td>--%>
                <td>
                    <c:select path="category">
                        <c:options items="${categoryList}"/>
                    </c:select>
                </td>
                <td>
                    <c:select path="country">
                        <c:options items="${countryList}"/>
                    </c:select>
                </td>
                <td colspan="2"><input type="submit" value="Добавить/Изменить"/></td>
            </tr>
        </table>
    </form:form>
</dif>
</body>
</html>
