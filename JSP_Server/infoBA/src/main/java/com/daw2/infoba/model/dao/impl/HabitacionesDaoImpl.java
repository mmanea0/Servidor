package com.daw2.infoba.model.dao.impl;
import com.daw2.infoba.model.dao.ConectaBD;
import com.daw2.infoba.model.dao.HabitacionesDao;
import com.daw2.infoba.model.dao.ProveedoresDao;
import com.daw2.infoba.model.entity.Articulo;
import com.daw2.infoba.model.entity.Habitacion;
import com.daw2.infoba.model.entity.Proveedor;

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
                Habitacion habitacion = new Habitacion();
                habitacion.setId(rs.getInt("habitacion_id"));
                entity.setHabitacion(habitacion);
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

    private Integer _add(Habitacion entity) throws SQLException {
        Integer id;
        String sql = "INSERT INTO habitaciones "
                + "(numero, capacidad, fumador, descripcion, created_at, modified_at) VALUES "
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entity.getNumero());
        ps.setString(2, entity.getCapacidad());
        ps.setDouble(3, entity.getFumador());
        ps.setInt(4, entity.getHabitacion!=null?entity.getHabitacion().getId():null);
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


    public List<Habitacion> listAllFillProveedor() {
        HabitacionesDao habitacionesDao = new HabitacionesDaoImpl();
        List<Habitacion> list = listAll();
        list.forEach(e->e.setHabitacion(habitacionesDao.get(e.getHabitacion().getId())));
        return list;
    }
}