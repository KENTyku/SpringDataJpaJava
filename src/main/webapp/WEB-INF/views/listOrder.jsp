<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 06.12.18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Productsbascket</title>
</head>
<body>
<dif>
    <h1>Корзина</h1>
    <table border="1">
        <tr>
            <td><b>id товара:</b></td>
            <td><b>Наименование:</b></td>
            <td><b>Описание:</b></td>
            <td><b>Цена:</b></td>
            <td><b>Категория:</b></td>
            <td><b>Производитель:</b></td>
            <td><b>Количество</b></td>
            <td><b>Удалить из корзины</b></td>
        </tr>
        <c:forEach var="orderPosition" items="${orderPositionList}">
            <%--<form:form method="POST" modelAttribute="orderModel">--%>
                <%--&lt;%&ndash;<form:input path="orderId" type="hidden" value="${orderModel.orderId}" id="orderId_listOrder"/>&ndash;%&gt;--%>
                <%--<form:input path="idProduct" type="hidden" value="${orderPosition.id.product.id}" id="productId_listForOrder"/>--%>
                <tr>
                    <td>${orderPosition.id.product.id}</td>
                    <td>${orderPosition.id.product.name}</td>
                    <td>${orderPosition.id.product.comment}</td>
                    <td>${orderPosition.id.product.price}</td>
                    <td>${orderPosition.id.product.category.categoryName}</td>
                    <td>${orderPosition.id.product.country.name}</td>
                    <td>${orderPosition.quantity}</td>
                    <%--<td colspan="2"><input type="submit" value="Удалить из корзины"/></td>--%>
                </tr>
            <%--</form:form>--%>
        </c:forEach>
    </table>

</dif>
<dif>
    <form:form method="POST" modelAttribute="orderModel" action="addOrderItem">
        <form:input path="orderId" type="hidden" value="${order.id}" id="orderId_listOrder"/>
        <td colspan="2"><input type="submit" value="Продолжить покупки"/></td>
    </form:form>
    <br>
    <%--<a href="createOrder?newOrder">Продолжить выбор товаров</a><br>--%>
    <a href="home">На главную</a><br>
</dif>
</body>
</html>
