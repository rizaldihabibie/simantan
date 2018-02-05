package com.niscalindo.simantan.database.dao.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.niscalindo.simantan.database.dao.MapDao;
import com.niscalindo.simantan.database.helper.DatabaseHelper;

/**
 * Created by USER on 2/4/2018.
 */
public class MapDaoImpl implements MapDao {
    private Cursor cursor;
    private DatabaseHelper dbHelper;

    @Override
    public long insert(ContentValues contentValues, Context context) {
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long rowId = db.insert("locations",null,contentValues);
        return rowId;
    }

    @Override
    public int delete(Context context) {
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int count = db.delete("locations",null,null);
        return 0;
    }

    @Override
    public Cursor getAllLocations(Context context) {
        return null;
    }
}
