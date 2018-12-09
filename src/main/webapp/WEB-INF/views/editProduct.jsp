<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <table border="10">

            <tr>
                <td><b>id товара:</b></td>
                <td><form:input path="id" type="text" id="id_editProduct"
                                value="введите id" size="70"/></td>
            </tr>

            <tr>
                <td><b>Наименование:</b></td>
                <td><form:input path="name" type="text" id="name_editProduct"
                                value="наименование" size="65"/></td>
            </tr>

            <tr>
                <td><b>Описание:</b></td>
                <td><form:input path="comment" type="text" id="comment_editProduct"
                                value="описание" size="200"/></td>
            </tr>

            <tr>
                <td><b>Цена:</b></td>
                <td><form:input path="price" type="text" id="price_editProduct"
                                value="цена" size="65"/></td>
            </tr>

            <tr>
                <td><b>Категория:</b></td>
                <td><form:input path="cateroty" type="text" name="category_editProduct"
                                value="категория" size="65"/></td>
            </tr>

            <tr>
                <td><b>Производитель:</b></td>
                <td><form:input path="county" type="text" name="country_editProduct"
                                value="Производитель" size="65"/></td>
            </tr>

                <%--<tr>--%>
                <%--<td>Parameter choice</td>--%>
                <%--<td>--%>
                <%--<select name = "possible-result">--%>
                <%--<option value = "SUCCESS">Success</option>--%>
                <%--<option value = "ERR-500">ERR-500 Technical error</option>--%>
                <%--<option value = "ERR-1003">ERR-1003 Requested information is not available</option>--%>
                <%--<option value = "ERR-1005">ERR-1005 Some other Error</option>--%>
                <%--</select>--%>
                <%--</td>--%>
                <%--</tr>--%>

            <tr>
                <td colspan="2"><input type="submit" value="Добавить/Изменить"/></td>
            </tr>
        </table>
    </form:form>
</dif>
</body>
</html>
