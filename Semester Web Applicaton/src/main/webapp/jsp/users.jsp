<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 27.10.2020
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>FROM JSP USERS</h1>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>AGE</th>
        </tr>
        <c:forEach items="${usersForJsp}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
        <%--        <%--%>
        <%--            List<User> users = (List<User>) request.getAttribute("usersForJsp");--%>
        <%--            for (int i = 0; i < users.size(); i++) {--%>
        <%--        %>--%>
        <%--        <tr>--%>
        <%--            <td><%=users.get(i).getId()%></>--%>
        <%--            <td><%=users.get(i).getFirstName()%></>--%>
        <%--            <td><%=users.get(i).getLastName()%></>--%>
        <%--            <><%=users.get(i).getAge()%></>--%>
        <%--        </tr>--%>
        <%--        <%}%>--%>
    </table>
</div>
</body>
</html>
