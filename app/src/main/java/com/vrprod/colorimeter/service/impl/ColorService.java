package com.vrprod.colorimeter.service.impl;

import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.service.IColorService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorService implements IColorService {

    private List<Color> lstColors = new ArrayList<>();

    @Override
    public Color getByCodeHexadecimal(String codeHexadecimal) {
        if (codeHexadecimal == null || codeHexadecimal.isEmpty()) {
            return null;
        }
        Color color = null;
        Iterator<Color> itColor = lstColors.iterator();
        while (color == null && itColor.hasNext()) {
            Color c = itColor.next();
            if (c != null && codeHexadecimal.equals(c.getCodeHexadecimal())) {
                color = c;
            }
        }
        return color;
    }

    @Override
    public List<Color> getAll() {
        lstColors = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            lstColors.add(new Color(data[i][0], data[i][1]));
        }
        return lstColors;
    }

    @Override
    public Color save(Color color) {
        if (color == null) {
            return null;
        }
        lstColors.add(color);
        return color;
    }

    @Override
    public boolean delete(Color color) {
        if (color == null) {
            return false;
        }
        lstColors.remove(color);
        return true;
    }

    private String[][] data = new String[][] {
            {"BlanchedAlmond",			"#FFEBCD"},
            {"Coral",					"#FF7F50"},
            {"DarkGray",				"#A9A9A9"},
            {"DarkOliveGreen",			"#556B2F"},
            {"DarkOrchid",				"#9932CC"},
            {"DarkSalmon",				"#E9967A"},
            {"DarkSlateGray",			"#2F4F4F"},
            {"DeepPink",				"#FF1493"},
            {"FireBrick",				"#B22222"},
            {"Fuchsia",					"#FF00FF"},
            {"Gray",					"#808080"},
            {"GreenYellow",				"#ADFF2F"},
            {"Ivory",					"#FFFFF0"},
            {"Lavender",				"#E6E6FA"},
            {"LightBlue",				"#ADD8E6"},
            {"LightGoldenRodYellow",	"#FAFAD2"},
            {"Lime",					"#00FF00"},
            {"OldLace",					"#FDF5E6"},
            {"Pink",					"#FFC0CB"},
            {"Snow",					"#FFFAFA"},
            {"Teal",					"#008080"},
            {"Wheat",					"#F5DEB3"}
    };
}
