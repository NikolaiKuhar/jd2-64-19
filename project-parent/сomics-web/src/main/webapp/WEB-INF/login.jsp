<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
<table>
    <tr>
        <td> <label for ="userName">User name</label></td>
        <td> <input id ="userName" type="text" name="userName"></td>
    </tr>
    <tr>
        <td> <label for ="password">Password</label></td>
        <td> <input id ="password" type="password" name="password"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit">
        </td>
    </tr>
</table>
</form>



</body>
</html>
