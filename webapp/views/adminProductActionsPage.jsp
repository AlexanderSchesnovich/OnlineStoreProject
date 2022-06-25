<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin actions with products</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Products</h2>
            <button onclick="location.href='views/createProductForm.jsp'">Create product</button>
        </div>
        <c:forEach var="prod" items="${products}">
            <p>Model: <c:out value="${prod.name}"/></p>
            <p>Price: <c:out value="${prod.price}"/></p>
            <p>Description: <c:out value="${prod.description}"/></p>
            <p>
                <button onclick="location.href='views/modifyProductForm.jsp?id=${prod.id}'">Modify product</button>
                <button onclick="location.href='/product/delete?id=${prod.id}'">Delete product</button>
            </p>
        </c:forEach>
    </div>
</div>
</body>
</html>