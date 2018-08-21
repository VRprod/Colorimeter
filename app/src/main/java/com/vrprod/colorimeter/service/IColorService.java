package com.vrprod.colorimeter.service;

import com.vrprod.colorimeter.model.Color;

import java.util.List;

public interface IColorService {

    Color create(Color color);
    boolean delete(Long id);
    List<Color> readAll();
    Color readById(Long id);
    boolean update(Color color);
}
