package com.niscalindo.simantan.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by USER on 2/4/2018.
 */
public interface MapDao {
    public long insert(ContentValues contentValues, Context context);
    public int delete(Context context);
    public Cursor getAllLocations(Context context);
}
