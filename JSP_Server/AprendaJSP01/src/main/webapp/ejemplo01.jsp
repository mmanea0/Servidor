<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: daw2
  Date: 14/09/2022
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Mi primer JSP</h1>

<%--El menor porciento igual sirve para visualizar codigo java --%>
<p>1. La hora actual del servidor es <%=new Date()%></p>

<p>2. La hora actual del servidor es
    <%=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())%> </p>

<%--Sin el igual sirve para añadir codigo sin visualizar--%>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String fecha =sdf.format(new Date());
%>
<p>3. La hora actual del servidor es; <%=fecha%></p>

<%--Con las exclamaciones es para declarar funciones--%>
<%!
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private String fechaSistema(){
        return sdf.format(new Date());
    }
%>
<p>4. La hora actual del servidor es; <%=fechaSistema()%></p>

<%
    System.out.println("<p>5.La hora del servidor es: "+fechaSistema()+"</P>");
%>
</body>
</html>
