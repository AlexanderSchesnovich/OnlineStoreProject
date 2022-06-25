<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin actions with users</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Users</h2>
        </div>
        <c:forEach var="user" items="${users}">
            <p>Name: <c:out value="${user.login}"/></p>
            <p>
                <button onclick="location.href='viewsmodifyUserForm.jsp?id=${prod.id}'">Modify</button>
                <button onclick="location.href='/user/delete?id=${prod.id}'">Delete</button>
            </p>
        </c:forEach>
    </div>
</div>
</body>
</html>
