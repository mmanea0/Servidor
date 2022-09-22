package com.daw2.infoba.model.dao;

import com.daw2.infoba.model.entity.Habitacion;
import com.daw2.infoba.model.entity.Proveedor;

import java.util.List;

public interface HabitacionesDao extends Dao<Habitacion, Integer> {
    List <Habitacion> listAllFillHabitacion();
}
