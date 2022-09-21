<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown link
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--Mensaje de todo correcto, verde--%>
<%if (request.getAttribute("alertSuccess") != null) {%>
<div class="alert alert-success mensaje-temporal">
    <i class="fa-solid fa-thumbs-up fa-1x"></i> <%--Esto es el icono--%>
    <%=request.getAttribute("alertSuccess")%>
</div>
<%}%>

<%--Mensaje de Peligro, rojo--%>
<%if (request.getAttribute("alertDanger") != null) {%>
<div class="alert alert-danger mensaje-temporal">
    <i class="fa-solid fa-thumbs-down fa-1x"></i>
    <%=request.getAttribute("alertDanger")%>
</div>
<%}%>

<%--Mensaje de Cuidado--%>
<%if (request.getAttribute("alertWarning") != null) {%>
<div class="alert alert-warning mensaje-temporal">
    <i class="fa-solid fa-triangle-exclamation fa-1x"></i>
    <%=request.getAttribute("alertWarning")%>
</div>
<%}%>

<%if (request.getAttribute("alertInfo") != null) {%>
<div class="alert alert-info mensaje-temporal">
    <i class="fa-solid fa-square-info fa-1x"></i>
    <%=request.getAttribute("alertInfo")%>
</div>
<%}%>