package com.daw2.infoba.model.dao.impl;
import com.daw2.infoba.model.dao.ConectaBD;
import com.daw2.infoba.model.dao.HabitacionesDao;
import com.daw2.infoba.model.entity.Habitacion;
import com.daw2.infoba.model.entity.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HabitacionesDaoImpl implements HabitacionesDao {

    private Connection  connection;

    private boolean error;

    public HabitacionesDaoImpl(){
        super();
        error=false;
        try {
           connection = ConectaBD.getConnection();
        }catch (SQLException e){
            error = true;
            System.out.println("Se ha producido un erro ¡r al acceder a la BD");
        }
    }

    @Override
    public Integer add(Habitacion entity) {
        return null;
    }

    @Override
    public boolean add(List<Habitacion> list) {
        return false;
    }

    @Override
    public boolean update(Habitacion entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public Habitacion get(int id) {
        return null;
    }

    @Override
    public List<Habitacion> listAll() {
        return null;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public boolean exist(int id) {
        return HabitacionesDao.super.exist(id);
    }

    @Override
    public Date utilDateToSqlDate(java.util.Date date) {
        return HabitacionesDao.super.utilDateToSqlDate(date);
    }

    @Override
    public java.util.Date sqlDateToUtilDate(Date date) {
        return HabitacionesDao.super.sqlDateToUtilDate(date);
    }

    @Override
    public List<Habitacion> listAllFillHabitacion() {
        return null;
    }
}
