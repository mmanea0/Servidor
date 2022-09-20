<%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 15/09/2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Declaracion de los datos para procesar los datos--%>
<%
    String nif=(String) request.getAttribute("nif");
    String nombre=(String) request.getAttribute("nombre");
    String apellido1=(String) request.getAttribute("apellido1");
    String apellido2=(String) request.getAttribute("apellido2");
%>

<html>
<head>
    <title>Aprende JSP</title>
    <%--Sirve para establecer el punto de partida de la ruta--%>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>

<h1>Ficha del usuario</h1>
<%--Request es para recuperar los datos de los campos anteriores--%>
NIF: <%= nif%>
Nombre: <%= nombre%> <br>
Primer apellido: <%= apellido1%> <br>
Segundo apellido: <%= apellido2%> <br>

<a href="usuarios/alta"> Nuevo usuario</a>
</body>
</html>
