<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorization error</title>
</head>
<body>
<p>You are not authorized!</p>
<p>Active user? Sign in!</p>
<button onclick="location.href='/views/createAccountPage.jsp'">Sign in</button>
<p>Don't have an account? Sign up!</p>
<button onclick="location.href='/views/signUpForm.jsp'">Sign up</button>
</body>
</html>
