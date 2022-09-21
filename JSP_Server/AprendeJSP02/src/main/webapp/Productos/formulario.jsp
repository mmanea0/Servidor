<%@ page import="com.daw2.aprendejsp02.model.entity.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: luis_
  Date: 21/09/2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Producto producto=(Producto) request.getAttribute("producto");
    List<Producto> productos= (List<Producto>) request.getAttribute("productos");
    Map errors = (Map) request.getAttribute("errors");

%>

<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<h1>Productos</h1>

<table>
    <form action="productos" method="post">
        <tr>
            <th>
            Nombre <input type="text" name="nombre" value="<%=producto.getNombre()%>">
            <% if (errors.get("nombre") != null) { %>
                <div style="background-color: red; color: blue; font-size: 0.7em; font-family: italic">
            <%=errors.get("nombre")%>
                </div>
            <%}%>
            </th>
        </tr>
        <tr>
            <th>
                Descripcion <input type="text" name="descripcion" value="<%=producto.getDescripcion()%>">
                <% if (errors.get("descripcion") != null) { %>
                <div style="background-color: red; color: blue; font-size: 0.7em; font-family: italic">
                    <%=errors.get("discripcion")%>
                </div>
                <%}%>
            </th>
        </tr>
        <tr>
            <th>
                Precio <input type="text" name="precio" value="<%=producto.getPrecio()%>">
                <% if (errors.get("precio") != null) { %>
                <div style="background-color: red; color: blue; font-size: 0.7em; font-family: italic">
                    <%=errors.get("precio")%>
                </div>
                <%}%>
            </th>
        </tr>
        <tr>
            <th>
                Unidades <input type="text" name="unidades" value="<%=producto.getNombre()%>">
                <% if (errors.get("unidades") != null) { %>
                <div style="background-color: red; color: blue; font-size: 0.7em; font-family: italic">
                    <%=errors.get("unidades")%>
                </div>
                <%}%>
            </th>
        </tr>
        <tr>
            <th><input type="submit" value="Registrar"></th>
        </tr>
    </form>
</table>

</body>
</html>
