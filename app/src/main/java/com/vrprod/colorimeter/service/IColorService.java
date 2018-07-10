package com.vrprod.colorimeter.service;

import com.vrprod.colorimeter.model.Color;

import java.util.List;

public interface IColorService {

    Color getByCodeHexadecimal(String codeHexadecimal);
    List<Color> getAll();
    Color save(Color color);
    boolean delete(Color color);
}
