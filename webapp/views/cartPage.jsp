<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Cart</title>
</head>
<body>

<form action="<c:url value="/add_to_cart"/>" method="GET">
    <c:forEach items="${cart.products}" var="product">
        <span>${product.name}</span>
    </c:forEach>
</form>

</body>
</html>