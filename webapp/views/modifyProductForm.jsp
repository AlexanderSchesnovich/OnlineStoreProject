<html>
<head>
    <title>Modify product</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>New name</th>
        <th>New price</th>
        <th>New amount</th>
    </tr>
    </thead>
    <tbody>
    <form action="/product/modify" method="GET">
        <tr>
            <td><input type = "text" name="id" readonly="readonly" value="<%=request.getParameter("id")%>"/></td>
            <td><input type="text" name="name" required placeholder="New name"></td>
            <td><input type="number" name="price" required placeholder="New price"></td>
            <td><input type="number" name="amount" required placeholder="New amount"></td>
            <td><input type="submit" value="Modify product"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>