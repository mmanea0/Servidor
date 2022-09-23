package com.daw2.infoba.model.dao.impl;

import com.daw2.infoba.model.dao.ConectaBD;
import com.daw2.infoba.model.dao.HabitacionesDao;
import com.daw2.infoba.model.entity.Habitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDaoImpl implements HabitacionesDao {
    private Connection connection;

    private boolean error;

    public HabitacionesDaoImpl() {
        super();
        error = false;
        try {
            connection = ConectaBD.getConnection();
        } catch (SQLException e) {
            error = true;
            System.out.println("Se ha producido un erro ¡r al acceder a la BD");
        }
    }

    @Override
    public Integer add(Habitacion entity) {
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
    public boolean add(List<Habitacion> list) {
        error = false;
        try {
            for (Habitacion entity : list) {
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
    public boolean update(Habitacion entity) {
        error = false;
        String sql = "UPDATE habitaciones SET "
                + "numero=?, capacidad=?, fumador=?, descripcion=?, "
                + "created_at=?, modified_at=? "
                + "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getNumero());
            ps.setInt(2, entity.getCapacidad());
            ps.setBoolean(3, entity.getFumador());
            ps.setString(4, entity.getDescripcion());
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
        String sql = "DELETE FROM habitaciones "
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
            String sql = "DELETE FROM habitaciones";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            error = true;
        }
        return !error;
    }

    @Override
    public Habitacion get(int id) {
        error = false;
        Habitacion entity = null;
        String sql = "SELECT "
                + "id, numero,capacidad, fumador, descripcion, "
                + "created_at, modified_at "
                + "FROM habitaciones WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entity = new Habitacion();
                entity.setId(rs.getInt("id"));
                entity.setNumero(rs.getString("numero"));
                entity.setCapacidad(rs.getInt("capacidad"));
                entity.setFumador(rs.getBoolean("fumador"));
                entity.setDescripcion(rs.getString("descripcion"));
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setCreatedAt(rs.getDate("modified_at"));
            }
            rs.close();
        } catch (Exception ex) {
            error = true;
        }
        return entity;
    }


    public List<Habitacion> listAll() {
        error = false;
        Habitacion entity = null;
        List<Habitacion> list = new ArrayList<>();
        String sql = "SELECT "
                + "id, numero, capacidad, fumador, descripcion, created_at, modified_at "
                + "FROM habitaciones";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entity = new Habitacion();
                entity.setId(rs.getInt("id"));
                entity.setNumero(rs.getString("numero"));
                entity.setCapacidad(rs.getInt("capacidad"));
                entity.setFumador(rs.getBoolean("fumador"));
                entity.setDescripcion(rs.getString("descripcion"));
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

    @Override
    public boolean exist(int id) {
        return HabitacionesDao.super.exist(id);
    }

    private Integer _add(Habitacion entity) throws SQLException {
        Integer id;
        String sql = "INSERT INTO habitaciones "
                + "(numero, capacidad, fumador, descripcion, created_at, modified_at) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entity.getNumero());
        ps.setInt(2, entity.getCapacidad());
        ps.setBoolean(3, entity.getFumador());
        ps.setString(4, entity.getDescripcion());
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

    @Override
    public List<Habitacion> listAllFillHabitacion() {
        return null;
    }
}
