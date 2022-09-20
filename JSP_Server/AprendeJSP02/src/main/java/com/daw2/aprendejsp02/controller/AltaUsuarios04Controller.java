package com.daw2.aprendejsp02.controller;

import com.daw2.aprendejsp02.model.entity.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//el value sirve para poner la forma abreviada en el navegador
//el value va con barra y en l form va sin barra
@WebServlet(name = "AltaUsuariosController", value ="/usuarios/alta_ej04")
public class AltaUsuarios04Controller extends HttpServlet {
    private List<Usuario> usuarios;

    //para cuando se inicialice el servidor comience el metodo
    @Override
    public void init() throws ServletException {
        usuarios=new ArrayList();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Usuario usuario=new Usuario();
        usuario.setNif("");
        usuario.setNombre("");
        usuario.setApellido1("");
        usuario.setApellido2("");

        request.setAttribute("usuario",usuario);
        request.setAttribute("usuarios",usuarios);
        request.setAttribute("errors",new HashMap());

        request.getRequestDispatcher("/ej04/formulario.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //esto es para procesar los datos recibidos
        String nif = request.getParameter("nif").trim();
        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();

        //clase usuario
        Usuario usuario=new Usuario();
        usuario.setNif(nif);
        usuario.setNombre(nombre);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);

        Map errors= new HashMap();
        if (nif.isEmpty())
            errors.put("nif","El nif no puede estar vacio");
        if (nombre.isEmpty())
            errors.put("nombre","El nombre no puede estar vacio");
        if (apellido1.isEmpty())
            errors.put("apellido1","El apellido1 no puede estar vacio");

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("usuario",usuario);
        request.setAttribute("errors",errors);
        request.setAttribute("usuarios",usuarios);

        if(errors.isEmpty()) {
            usuarios.add(usuario);
            request.getRequestDispatcher("/ej04/formulario.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/ej04/formulario.jsp").forward(request,response);
    }
}
