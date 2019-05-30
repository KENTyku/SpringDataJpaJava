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
    <title>Registration</title>
</head>
<body>
Регистрация на сайте:
<form method="POST" action="registrationClient" enctype="multipart/form-data">
    <table>
        <tr>
            <td><b>Логин:</b></td>
            <td><input name="login" type="text"/></td>
            <td>${messageLogin}</td>
        </tr>
        <tr>
            <td><b>Пароль:</b></td>
            <td><input name="password" type="password" id="password_registration"/></td>
            <td>${messagePassword}</td>
        </tr>
        <tr>
            <td><b>Подтверждение пароля:</b></td>
            <td><input name="passwordConfirm" type="password" id="passwordConfirm_registration"/></td>
            <td>${messagePassword}</td>
        </tr>
        <tr>
            <td>${messageEmpty}${messageShort}</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Зарегистрироваться"/></td>
        </tr>
    </table>
</form>
</body>
</html>
