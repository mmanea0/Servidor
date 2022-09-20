package com.daw2.aprendejsp02.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//el value sirve para poner la forma abreviada en el navegador
//el value va con barra y en l form va sin barra
@WebServlet(name = "AltaUsuariosController", value ="/usuarios/alta")
public class AltaUsuariosController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("nif","");
        request.setAttribute("nombre","");
        request.setAttribute("apellido1","");
        request.setAttribute("apellido2","");
        request.setAttribute("errors",new HashMap());

        request.getRequestDispatcher("/ej03/formulario.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //esto es para procesar los datos recibidos
        String nif = request.getParameter("nif").trim();
        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();

        //empty quiere decir si esta vacio el campo
        Map errors= new HashMap();
        if (nif.isEmpty())
            //la sintasis es el nombre del objeto + el mensaje que debe aparecer
            errors.put("nif","El nif no puede estar vacio");
        if (nombre.isEmpty())
            errors.put("nombre","El nombre no puede estar vacio");
        if (apellido1.isEmpty())
            errors.put("apellido1","El apellido1 no puede estar vacio");

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("nif",nif);
        request.setAttribute("nombre",nombre);
        request.setAttribute("apellido1",apellido1);
        request.setAttribute("apellido2",apellido2);
        //para mostrar los errores que se han producido
        request.setAttribute("errors",errors);

        //en funcion de si hay error o no te manda a la ficha o al formulario de vuelta
        if(errors.isEmpty())
            request.getRequestDispatcher("/ej03/ficha.jsp").forward(request,response);
        else
            request.getRequestDispatcher("/ej03/formulario.jsp").forward(request,response);
    }
}
