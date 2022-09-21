package com.daw2.aprendejsp02.controller;

import com.daw2.aprendejsp02.model.entity.Producto;
import com.daw2.aprendejsp02.model.entity.Usuario;
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
@WebServlet(name = "ProductosController", value ="/productos")
public class ProductosController extends HttpServlet {
    private List<Producto> productos;

    //para cuando se inicialice el servidor comience el metodo
    @Override
    public void init() throws ServletException {
        productos=new ArrayList();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Producto producto=new Producto();
        producto.setNombre("");
        producto.setDescripcion("");
        producto.setPrecio(0.0);
        producto.setUnidades(0.0);

        request.setAttribute("producto",producto);
        request.setAttribute("productos",productos);
        request.setAttribute("errors",new HashMap());

        request.getRequestDispatcher("/Productos/formulario.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //esto es para procesar los datos recibidos
        String nombre = request.getParameter("nombre").trim();
        String descripcion = request.getParameter("descripcion").trim();
        Double precio = Double.valueOf(request.getParameter("precio").trim());
        Double unidades = Double.valueOf(request.getParameter("unidades").trim());

        //clase usuario
        Producto producto=new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setUnidades(unidades);

        Map errors= new HashMap();
        if (nombre.isEmpty())
            errors.put("nombre","El nombre no puede estar vacio");
        if (descripcion.isEmpty())
            errors.put("descripcion","La descripcion no puede estar vacio");
        if (String.valueOf(precio).isEmpty())
            errors.put("precio","El precio no puede estar vacio");
        if(String.valueOf(unidades).isEmpty())
            errors.put("unidades","Las unidades no pueden estar vacias");

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("producto",producto);
        request.setAttribute("errors",errors);
        request.setAttribute("productos",productos);

        if(errors.isEmpty()) {
            productos.add(producto);
            request.getRequestDispatcher("/Productos/formulario.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/Productos/formulario.jsp").forward(request,response);
    }
}
