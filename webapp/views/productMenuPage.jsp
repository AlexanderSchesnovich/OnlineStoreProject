<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Products</h2>
<%--            <button onclick="location.href='views/user_actions/cartPage.jsp'">Cart</button>--%>
        </div>
        <c:forEach var="prod" items="${products}">
            <p>Model: <c:out value="${prod.name}"/></p>
            <p>Price: <c:out value="${prod.price}"/></p>
            <p>Description: <c:out value="${prod.description}"/></p>
<%--            <p>--%>
<%--                <button onclick="location.href='/buy?id=${prod.id}&name=${prod.name}&price=${prod.price}&description=${prod.description}&amount=${prod.amount}'">Buy</button>--%>
<%--                <button onclick="location.href='/add-cart?id=${prod.id}&name=${prod.name}&price=${prod.price}&description=${prod.description}&amount=${prod.amount}'">Add to basket</button>--%>
<%--            </p>--%>
        </c:forEach>
    </div>
</div>
</body>
</html>