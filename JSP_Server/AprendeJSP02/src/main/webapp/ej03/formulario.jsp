<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 15/09/2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String nif=(String) request.getAttribute("nif");
    String nombre=(String) request.getAttribute("nombre");
    String apellido1=(String) request.getAttribute("apellido1");
    String apellido2=(String) request.getAttribute("apellido2");
    Map errors = (Map) request.getAttribute("errors");
%>

<html>
<head>
    <title>Aprende JSP</title>
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
            <th> NIF <input type="text" name="nif" value="<%=nif%>"> </th>
        </tr>
        <tr>
            <th> Nombre <input type="text" name="nombre" value="<%=nombre%>"> </th>
        </tr>
        <tr>
            <th> Primer Apellido <input type="text" name="apellido1" value="<%=apellido1%>"> </th>
        </tr>
        <tr>
           <th> Segundo Apellido <input type="text" name="apellido2" value="<%=apellido2%>"> </th>
        </tr>
        <tr>
           <th> <input type="submit" name="registar"> </th>
        </tr>
    </form>
 </table>
</body>
</html>
