<%--
  Created by IntelliJ IDEA.
  User: Mojgan
  Date: 16/11/24
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<form method="post" action="../RegisterServlet">
    <center>
        <table border="0" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="" /></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Already registered!! <a href="../login/index.jsp">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>