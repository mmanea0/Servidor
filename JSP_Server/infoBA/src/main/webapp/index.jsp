<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<jsp:include page="/layouts/head.jsp"></jsp:include>

<body>

<jsp:include page="/layouts/header.jsp"></jsp:include>

<div class="container">
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
</div>
<jsp:include page="/layouts/footer.jsp"></jsp:include>
</body>
</html>