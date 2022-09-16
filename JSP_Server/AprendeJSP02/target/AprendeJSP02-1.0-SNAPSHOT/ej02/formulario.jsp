<%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 15/09/2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aprende JSP</title>
</head>
<body>

<h1>Alta de formulario</h1>

<form action="ficha.jsp" method="post">
    Nombre <input type="text" name="nombre">
    <br>
    Primer Apellido <input type="text" name="apellido1">
    <br>
    Segundo Apellido <input type="text" name="apellido2">
    <br>
    <input type="submit" name="registar">
</form>

</body>
</html>
