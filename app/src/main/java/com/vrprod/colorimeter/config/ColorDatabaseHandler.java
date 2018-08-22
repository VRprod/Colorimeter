package com.vrprod.colorimeter.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ColorDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "colorimeter.db";
    protected static final String TABLE_COLOR = "COLOR";
    protected static final String COLUMN_ID = "ID";
    protected static final String COLUMN_NAME = "NAME";
    protected static final String COLUMN_CODE_HEXADECIMAL = "CODE_HEXADECIMAL";

    public ColorDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = new StringBuilder() //
                .append(" CREATE TABLE ").append(TABLE_COLOR).append(" ( ") //
                .append(COLUMN_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ") //
                .append(COLUMN_NAME).append(" TEXT, ") //
                .append(COLUMN_CODE_HEXADECIMAL).append(" TEXT ) ") //
                .toString();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = new StringBuilder("DROP TABLE IF EXISTS ").append(TABLE_COLOR).toString();
        db.execSQL(sql);
        onCreate(db);
    }
}
