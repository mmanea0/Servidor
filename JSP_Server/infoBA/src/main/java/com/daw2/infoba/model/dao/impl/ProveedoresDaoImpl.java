package com.daw2.infoba.model.dao.impl;

import com.daw2.infoba.model.dao.ConectaBD;
import com.daw2.infoba.model.dao.ProveedoresDao;
import com.daw2.infoba.model.entity.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDaoImpl implements ProveedoresDao {
    private Connection connection;
    private boolean error;

    public ProveedoresDaoImpl() {
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
    public Integer add(Proveedor entity) {
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
    public boolean add(List<Proveedor> list) {
        error = false;
        try {
            for (Proveedor entity : list) {
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
    public boolean update(Proveedor entity) {
        error = false;
        String sql = "UPDATE proveedores SET "
                + "nif=?, razon_social=?, nombre=?, apellido1=?, apellido2=?, telefono=?, email=?, "
                + "created_at=?, modified_at=? "
                + "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getNif());
            ps.setString(2, entity.getRazonSocial());
            ps.setString(3, entity.getNombre());
            ps.setString(4, entity.getApellido1());
            ps.setString(5, entity.getApellido2());
            ps.setString(6, entity.getTelefono());
            ps.setString(7, entity.getEmail());
            ps.setDate(8, utilDateToSqlDate(entity.getCreatedAt()));
            ps.setDate(9, utilDateToSqlDate(entity.getModifiedAt()));
            ps.setInt(10, entity.getId());
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
        String sql = "DELETE FROM provedores "
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
            String sql = "DELETE FROM proveedores";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            error = true;
        }
        return !error;
    }

    @Override
    public Proveedor get(int id) {
        error = false;
        Proveedor entity = null;
        String sql = "SELECT "
                + "id, nif, razon_social, nombre, apellido1, apellido2, telefono, email, "
                + "created_at, modified_at "
                + "FROM proveedores WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entity = new Proveedor();
                entity.setId(rs.getInt("id"));
                entity.setNif(rs.getString("nif"));
                entity.setRazonSocial(rs.getString("razon_social"));
                entity.setNombre(rs.getString("nombre"));
                entity.setApellido1(rs.getString("apellido1"));
                entity.setApellido2(rs.getString("apellido2"));
                entity.setTelefono(rs.getString("telefono"));
                entity.setEmail(rs.getString("email"));
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
    public List<Proveedor> listAll() {
        error = false;
        Proveedor entity = null;
        List<Proveedor> list = new ArrayList<>();
        String sql = "SELECT "
                + "id, nif, razon_social, nombre, apellido1, apellido2, telefono, email, "
                + "created_at, modified_at "
                + "FROM proveedores";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entity = new Proveedor();
                entity.setId(rs.getInt("id"));
                entity.setNif(rs.getString("nif"));
                entity.setRazonSocial(rs.getString("razon_social"));
                entity.setNombre(rs.getString("nombre"));
                entity.setApellido1(rs.getString("apellido1"));
                entity.setApellido2(rs.getString("apellido2"));
                entity.setTelefono(rs.getString("telefono"));
                entity.setEmail(rs.getString("email"));
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setCreatedAt(rs.getDate("modified_at"));
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

    private Integer _add(Proveedor entity) throws SQLException {
        Integer id;
        String sql = "INSERT INTO proveedores "
                + "(nif, razon_social, nombre, apellido1, apellido2, telefono, email. created_at, modified_at) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entity.getNif());
        ps.setString(2, entity.getRazonSocial());
        ps.setString(3, entity.getNombre());
        ps.setString(4, entity.getApellido1());
        ps.setString(5, entity.getApellido2());
        ps.setString(6, entity.getTelefono());
        ps.setString(7, entity.getEmail());
        // ps.setDate(7, new java.sql.Date(entity.getFechaAlta().getTime()));
        ps.setDate(8, utilDateToSqlDate(entity.getCreatedAt()));
        ps.setDate(9, utilDateToSqlDate(entity.getModifiedAt()));
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

}
