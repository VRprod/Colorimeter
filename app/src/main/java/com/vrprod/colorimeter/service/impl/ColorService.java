package com.vrprod.colorimeter.service.impl;

import android.content.Context;

import com.vrprod.colorimeter.dao.IColorDao;
import com.vrprod.colorimeter.dao.impl.ColorDao;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.service.IColorService;

import java.util.List;

public class ColorService implements IColorService {

    private IColorDao colorDao;

    public ColorService(Context context) {
        colorDao = new ColorDao(context);
    }

    @Override
    public Color create(Color color) {
        if (color == null) {
            return null;
        }
        return colorDao.create(color);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        return colorDao.delete(id);
    }

    @Override
    public List<Color> readAll() {
        return colorDao.readAll();
    }

    @Override
    public Color readById(Long id) {
        if (id == null) {
            return null;
        }
        return colorDao.readById(id);
    }

    @Override
    public boolean update(Color color) {
        if (color == null || color.getId() == null) {
            return false;
        }
        return colorDao.update(color);
    }
}
