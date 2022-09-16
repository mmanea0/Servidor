<%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 14/09/2022
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--El ejemplo solo se ve en el sevidor--%>
<h1>Ejemplo1</h1>
<%
  for (int i=1; i<10; i++){
    System.out.println("Numero "+i);
  }
%>

<h1>Ejemplo2</h1>
<%--Este ejemplo se ve en el navegador en una sola linea--%>
<%
    for (int i=1;i<10;i++){ %>
        Numero:<%=i%><%
    }%>

<h1>Tabla multiplicar</h1>
<%
    for (int i=0;i<=10;i++){%>
        3 x <%=i%> = <%=3*i%> <br>
<%}%>

<h1>Tabla con la tabla del 3</h1>

    <table border="1">
        <tr>
            <th>Factor1</th>
            <th>Factor2</th>
            <th>Resultado</th>
        </tr>
        <%for (int i=0;i<=10;i++) {%>
        <tr>
            <td>3</td>
            <td><%=i%></td>
            <td><%=3*i%></td>

        </tr>
        <%}%>
    </table>
</body>
</html>
