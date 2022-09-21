package com.daw2.infoba.model.dao;


import com.daw2.infoba.model.entity.Articulo;

import java.util.List;

public interface ArticulosDao extends Dao<Articulo, Integer> {
    List<Articulo> listAllFillProveedor();
}
