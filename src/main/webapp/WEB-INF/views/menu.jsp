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
    <title>Информация о заказе</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background: url(/resources/images/background.png);
        }
    </style>
</head>
<body>
<div class="container">
<%--    <table cellpadding="10" width="50%">--%>
<%--        <tr>--%>
<%--            <td align="left"><a href="home">Каталог товаров</a><br></td>--%>
<%--            <td align="center"><a href="orders">Список заказов</a><br></td>--%>
<%--            <td align="right"><a href="cart">Корзина</a><br></td>--%>
<%--            <td align="right"><a href="clients">Клиенты</a><br></td>--%>
<%--            <td align="right"><a href="registration">Регистрация</a><br></td>--%>
<%--            <td align="right"><a href="login">Вход</a><br></td>--%>
<%--            <td align="right"><a href="logout">Выход</a><br></td>--%>
<%--        </tr>--%>
<%--    </table>--%>


    <div class="row">
        <div class="col"><a href="home">Каталог товаров</a></div>
        <div class="col"><a href="orders">Список заказов</a></div>
        <div class="col"><a href="cart">Корзина</a></div>
        <div class="col"><a href="clients">Клиенты</a></div>
        <div class="col"><a href="registration">Регистрация</a></div>
        <div class="col"><a href="login">Вход</a></div>
        <div class="col"><a href="logout">Выход</a></div>
    </div>

</div>
</body>
</html>
