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
Вход:
<form method="POST" action="login">
    <table>
        <tr>
            <td><b>Логин:</b></td>
            <td><input name="username" type="text"/></td>
            <td>${messageLogin}</td>
        </tr>
        <tr>
            <td><b>Пароль:</b></td>
            <td><input name="password" type="password" id="password_registration"/></td>
            <td>${messagePassword}</td>
        </tr>
        <tr>
            <td>${messageEmpty}</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Войти"/></td>
        </tr>
    </table>
</form>
</body>
</html>
