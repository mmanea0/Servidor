package com.daw2.aprendejsp02.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
//el value sirve para poner la forma abreviada en el navegador
//el value va con barra y en l form va sin barra
@WebServlet(name = "AltaUsuariosController", value = "/usuarios/alta")
public class AltaUsuariosController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ej03/formulario.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //esto es para procesar los datos recibidos
        String nif = request.getParameter("nif").trim();
        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();



        request.setCharacterEncoding("UTF-8");
        request.setAttribute("nif",nif);
        request.setAttribute("nombre",nombre);
        request.setAttribute("apellido1",apellido1);
        request.setAttribute("apellido2",apellido2);

        request.getRequestDispatcher("/ej03/ficha.jsp").forward(request,response);
    }
}
