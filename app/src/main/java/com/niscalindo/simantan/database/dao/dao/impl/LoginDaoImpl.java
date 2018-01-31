package com.niscalindo.simantan.database.dao.dao.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.niscalindo.simantan.database.dao.LoginDao;
import com.niscalindo.simantan.database.helper.DatabaseHelper;
import com.niscalindo.simantan.database.model.Credential;

/**
 * Created by USER on 1/31/2018.
 */
public class LoginDaoImpl implements LoginDao {
    private Cursor cursor;
    @Override
    public Credential login(String username, String password, Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Credential cre = new Credential();
        cursor = db.rawQuery("SELECT * FROM credential WHERE username = '"+username+"' and password = '"+password+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            cre.setUsername(cursor.getString(1).toString());
            cre.setPassword(cursor.getString(2).toString());
        }else{
            cre.setUsername("kosong");
            cre.setPassword("kosong");
        }
        return cre;
    }
}
