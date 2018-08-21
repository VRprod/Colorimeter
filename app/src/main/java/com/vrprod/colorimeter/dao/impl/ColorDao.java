package com.vrprod.colorimeter.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vrprod.colorimeter.config.DatabaseHandler;
import com.vrprod.colorimeter.dao.IColorDao;
import com.vrprod.colorimeter.model.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorDao extends DatabaseHandler implements IColorDao {

    public ColorDao(Context context) {
        super(context);
    }

    @Override
    public Color create(Color color) {
        if (color == null) {
            return null;
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, color.getName());
        values.put(COLUMN_CODE_HEXADECIMAL, color.getCodeHexadecimal());

        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.insert(TABLE_COLOR, null, values);
        color.setId(id);

        db.close();
        return color;
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        String whereClause = "id = ?";
        String[] whereArgs = { id.toString() };

        SQLiteDatabase db = this.getWritableDatabase();
        boolean deleteSuccessful = db.delete(TABLE_COLOR, whereClause, whereArgs) > 0;

        db.close();
        return deleteSuccessful;
    }

    @Override
    public List<Color> readAll() {
        String sql = new StringBuilder(" SELECT * FROM ").append(TABLE_COLOR).append(" ORDER BY ").append(COLUMN_NAME).append(" ASC ").toString();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Color> lstColors = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String codeHexadecimal = cursor.getString(cursor.getColumnIndex(COLUMN_CODE_HEXADECIMAL));
                lstColors.add(new Color(id, name, codeHexadecimal));
            }
        }

        cursor.close();
        db.close();
        return lstColors;
    }

    @Override
    public Color readById(Long id) {
        if (id == null) {
            return null;
        }
        String sql = new StringBuilder(" SELECT * FROM ").append(TABLE_COLOR).append(" WHERE id = ").append(id).toString();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Color color = null;
        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String codeHexadecimal = cursor.getString(cursor.getColumnIndex(COLUMN_CODE_HEXADECIMAL));
            color = new Color(id, name, codeHexadecimal);
        }

        cursor.close();
        db.close();
        return color;
    }

    @Override
    public boolean update(Color color) {
        if (color == null || color.getId() == null) {
            return false;
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, color.getName());
        values.put(COLUMN_CODE_HEXADECIMAL, color.getCodeHexadecimal());

        String whereClause = "id = ?";
        String[] whereArgs = { color.getId().toString() };

        SQLiteDatabase db = this.getWritableDatabase();
        boolean updateSuccessful = db.update("students", values, whereClause, whereArgs) > 0;

        db.close();
        return updateSuccessful;
    }
}
