<%@ page import="java.util.Map" %>
<%@ page import="com.daw2.aprendejsp02.model.entity.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 20/09/2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Usuario usuario=(Usuario) request.getAttribute("usuario");
  List <Usuario> usuarios=(List<Usuario>) request.getAttribute("usuario");
  Map errors = (Map) request.getAttribute("errors");
%>

<html>
<head>
    <title>Title</title>
  <style>
    table{
      background-color: blue;
      border: black 1px;
    }
  </style>
  <base href="${pageContext.request.contextPath}/">
</head>
<body>

<h1>Alta de formulario</h1>
<table>
  <form action="usuarios/alta" method="post">
    <tr>
      <th>
        NIF <input type="text" name="nif" value="<%=usuario.getNif()%>">
        <% if(errors.get("nif") != null) { %>
        <div style="background-color: red; color: blue; font-size: 0.7em; font-family: italic">
          <%=errors.get("nif")%>
        </div>
        <%}%>
      </th>
    </tr>
    <tr>
      <th> Nombre <input type="text" name="nombre" value="<%=usuario.getNombre()%>"> </th>
    </tr>
    <tr>
      <th> Primer Apellido <input type="text" name="apellido1" value="<%=usuario.getApellido1()%>"> </th>
    </tr>
    <tr>
      <th> Segundo Apellido <input type="text" name="apellido2" value="<%=usuario.getApellido2()%>"> </th>
    </tr>
    <tr>
      <th> <input type="submit" name="registar"> </th>
    </tr>
  </form>
</table>

</body>
</html>
