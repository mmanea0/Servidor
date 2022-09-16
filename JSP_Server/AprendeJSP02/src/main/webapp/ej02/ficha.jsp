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
    <%--Sirve para establecer el punto de partida de la ruta--%>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>

<h1>Ficha del usuario</h1>
<%--Request es para recuperar los datos de los campos anteriores--%>
Nombre: <%= request.getParameter("nombre")%> <br>
Primer apellido: <%= request.getParameter("apellido1")%> <br>
Segundo apellido: <%= request.getParameter("apellido2")%> <br>

<a href=ej02/formulario.jsp> Nuevo usuario</a>
</body>
</html>
