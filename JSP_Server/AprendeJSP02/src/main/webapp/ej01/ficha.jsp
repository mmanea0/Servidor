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
    <%--He hecho este cambio--%>
    <title>Aprende JSP</title>
</head>
<body>

<h1>Ficha del usuario</h1>
<%--Request es para recuperar los datos de los campos anteriores--%>
Nombre: <%= request.getParameter("nombre")%> <br>
Primer apellido: <%= request.getParameter("apellido1")%> <br>
Segundo apellido: <%= request.getParameter("apellido2")%> <br>
</body>
</html>
<%--Y este otro cambio--%>