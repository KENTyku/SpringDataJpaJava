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
    <title>ClientsList</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div>
    <h3>Clietn list</h3>
    <%--<a href="editClient?id=new">Add client</a><br>--%>
    <table border="1">
        <tr>
            <td><b>Login:</b></td>
            <td><b>Name:</b></td>
            <td><b>Role:</b></td>
            <td><b>Edit:</b></td>
            <td><b>Delete:</b></td>
        </tr>
        <c:forEach var="client" items="${clientList}">

            <tr>
                <form:form method="post" action="editClient">
                    <input name="login" type="hidden" value="${client.login}" id="login_clients"/>
                    <td>${client.login}</td>
                    <%--<td><a href="editclient?id=${client.id}">${client.name}</a></td>--%>
                    <td>${client.name}</td>
                    <td>${client.role}</td>
                    <td colspan="1"><input type="submit" value="Edit"/></td>
                </form:form>
                <td colspan="1">
                    <form method="get" action="dellClient?login=${client.login}">
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
