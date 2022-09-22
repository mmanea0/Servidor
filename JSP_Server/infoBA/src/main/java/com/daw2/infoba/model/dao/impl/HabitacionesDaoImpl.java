package com.daw2.infoba.model.dao.impl;
import com.daw2.infoba.model.dao.HabitacionesDao;
import com.daw2.infoba.model.entity.Habitacion;

import java.sql.Date;
import java.util.List;


public class HabitacionesDaoImpl implements HabitacionesDao {


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
}
