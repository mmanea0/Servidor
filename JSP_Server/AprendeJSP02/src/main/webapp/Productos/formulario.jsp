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

</body>
</html>
