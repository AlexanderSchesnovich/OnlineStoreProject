<html>
<head>
    <title>Create new account</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Access level</th>
    </tr>
    </thead>
    <tbody>
    <form action="/create_account" method="POST">
        <tr>
            <td><input type="text" name="login" required placeholder="login"></td>
            <td><input type="password" name="password" required placeholder="password"></td>
            <td><input name="userType" type="radio" value="USER" checked> User</td>
            <td><input name="userType" type="radio" value="ADMIN"> Admin</td>
            <td><input type="submit" value="Create new account"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>