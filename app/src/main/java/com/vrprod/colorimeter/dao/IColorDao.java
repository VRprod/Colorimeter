package com.vrprod.colorimeter.dao;

import com.vrprod.colorimeter.model.Color;

import java.util.List;

public interface IColorDao {

    Color create(Color color);
    boolean deleteByCodeHexadecimal(String codeHexadecimal);
    List<Color> readAll();
    Color readById(Long id);
    boolean update(Color color);
}
