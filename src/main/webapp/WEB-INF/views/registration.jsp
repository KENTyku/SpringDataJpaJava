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
    <title>LoginPage</title>
</head>
<body>
Регистрация на сайте:
<form method="POST" action="registrationClient" enctype="multipart/form-data">
    <%--<input name="id" type="hidden" id="id_editProduct" value="${product.id}"/><br>--%>
    <table>
        <tr>
            <td><b>Логин:</b></td>
            <td><input name="login" type="text"/></td>
        </tr>
        <tr>
            <td><b>Пароль:</b></td>
            <td><input name="password" type="password" id="password_registration"/></td>
        </tr>
        <tr>
            <td><b>Подтверждение пароля:</b></td>
            <td><input name="passwordConfirm" type="password" id="passwordConfirm_registration"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Зарегистрироваться"/></td>
        </tr>
    </table>
</form>
</body>
</html>
