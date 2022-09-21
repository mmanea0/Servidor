package com.daw2.infoba.model.dao.impl;

import com.daw2.infoba.model.dao.ArticulosDao;
import com.daw2.infoba.model.dao.ConectaBD;
import com.daw2.infoba.model.dao.ProveedoresDao;
import com.daw2.infoba.model.entity.Articulo;
import com.daw2.infoba.model.entity.Proveedor;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDaoImpl implements ArticulosDao {
    private Connection connection;
    private boolean error;

    public ArticulosDaoImpl() {
        super();
        error = false;
        try {
            connection = ConectaBD.getConnection();
        } catch (SQLException e) {
            error = true;
            System.out.println("Se ha producido un error al acceder a la BD.");
        }
    }

    @Override
    public Integer add(Articulo entity) {
        Integer id = null;
        error = false;

        try {
            id = _add(entity);
            connection.commit();
        } catch (SQLException ex) {
            error = true;
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
        }
        return id;
    }

    @Override
    public boolean add(List<Articulo> list) {
        error = false;
        try {
            for (Articulo entity : list) {
                _add(entity);
            }
            connection.commit();
        } catch (SQLException ex) {
            error = true;
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
        }
        return !error;
    }

    @Override
    public boolean update(Articulo entity) {
        error = false;
        String sql = "UPDATE articulos SET "
                + "ref=?, descripcion=?, precio=?, proveedor_id=?, "
                + "created_at=?, modified_at=? "
                + "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getRef());
            ps.setString(2, entity.getDescripcion());
            ps.setDouble(3, entity.getPrecio());
            ps.setInt(4, entity.getProveedor()!=null?entity.getProveedor().getId():null);
            ps.setDate(5, utilDateToSqlDate(entity.getCreatedAt()));
            ps.setDate(6, utilDateToSqlDate(entity.getModifiedAt()));
            ps.setInt(7, entity.getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            error = true;
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
        }
        return !error;
    }

    @Override
    public boolean delete(int id) {
        error = false;
        String sql = "DELETE FROM articulos "
                + "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            error = true;
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
        }
        return !error;
    }

    @Override
    public boolean deleteAll() {
        error = false;
        try {
            String sql = "DELETE FROM articulos";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            error = true;
        }
        return !error;
    }

    @Override
    public Articulo get(int id) {
        error = false;
        Articulo entity = null;
        String sql = "SELECT "
                + "id, ref, descripcion, precio, proveedor_id, "
                + "created_at, modified_at "
                + "FROM articulos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entity = new Articulo();
                entity.setId(rs.getInt("id"));
                entity.setRef(rs.getString("ref"));
                entity.setDescripcion(rs.getString("descripcion"));
                entity.setPrecio(rs.getDouble("precio"));
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("proveedor_id"));
                entity.setProveedor(proveedor);
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setCreatedAt(rs.getDate("modified_at"));
            }
            rs.close();
        } catch (Exception ex) {
            error = true;
        }
        return entity;
    }

    @Override
    public List<Articulo> listAll() {
        error = false;
        Articulo entity = null;
        List<Articulo> list = new ArrayList<>();
        String sql = "SELECT "
                + "id, ref, descripcion, precio, proveedor_id, created_at, modified_at "
                + "FROM articulos";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entity = new Articulo();
                entity.setId(rs.getInt("id"));
                entity.setRef(rs.getString("ref"));
                entity.setDescripcion(rs.getString("descripcion"));
                entity.setPrecio(rs.getDouble("precio"));
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("proveedor_id"));
                entity.setProveedor(proveedor);
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setModifiedAt(rs.getDate("modified_at"));
                list.add(entity);
            }
            rs.close();
        } catch (SQLException ex) {
            error = true;
            list = null;
        }
        return list;
    }

    @Override
    public boolean isError() {
        return error;
    }

    /*--------------------*/
    /* Métodos auxiliares */
    /*--------------------*/

    private Integer _add(Articulo entity) throws SQLException {
        Integer id;
        String sql = "INSERT INTO articulos "
                + "(ref, descripcion, precio, proveedor_id, created_at, modified_at) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entity.getRef());
        ps.setString(2, entity.getDescripcion());
        ps.setDouble(3, entity.getPrecio());
        ps.setInt(4, entity.getProveedor()!=null?entity.getProveedor().getId():null);
        // ps.setDate(7, new java.sql.Date(entity.getFechaAlta().getTime()));
        ps.setDate(5, utilDateToSqlDate(entity.getCreatedAt()));
        ps.setDate(6, utilDateToSqlDate(entity.getModifiedAt()));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        } else {
            id = -1; // Si se ha añadido pero no se ha devuelto un id
        }

        return id;
    }

    /*-------------------------*/
    /* Métodos complementarios */
    /*-------------------------*/
    @Override
    public List<Articulo> listAllFillProveedor() {
        ProveedoresDao proveedoresDao = new ProveedoresDaoImpl();
        List<Articulo> list = listAll();
        list.forEach(e->e.setProveedor(proveedoresDao.get(e.getProveedor().getId())));
        return list;
    }
}
