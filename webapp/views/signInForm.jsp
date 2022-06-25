<html>
<head>
    <title>Sign in</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/user/signIn" method="GET">
        <tr>
            <td><input type="text" name="login" required placeholder="login"></td>
            <td><input type="password" name="password" required placeholder="password"></td>
            <td><input type="submit" value="Sign in"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>