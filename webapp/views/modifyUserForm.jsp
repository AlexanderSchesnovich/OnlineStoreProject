<html>
<head>
    <title>Modify product</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>New login</th>
        <th>New password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/user/modify" method="GET">
        <tr>
            <td><input type = "text" name="id" readonly="readonly" value="<%=request.getParameter("id")%>"/></td>
            <td><input type="text" name="login" required placeholder="New login"></td>
            <td><input type="text" name="password" required placeholder="New password"></td>
            <td><input type="text" name="userType" required placeholder="type of user"></td>
            <td><input type="submit" value="Modify user"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>