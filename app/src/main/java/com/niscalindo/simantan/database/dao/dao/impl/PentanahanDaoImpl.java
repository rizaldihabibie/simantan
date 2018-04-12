package com.niscalindo.simantan.database.dao.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.niscalindo.simantan.database.dao.PentanahanDao;
import com.niscalindo.simantan.database.helper.DatabaseHelper;
import com.niscalindo.simantan.database.model.Gardu;
import com.niscalindo.simantan.database.model.Pentanahan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 3/30/2018.
 */
public class PentanahanDaoImpl implements PentanahanDao {
    private Cursor cursor;
    private DatabaseHelper dbHelper;
    @Override
    public boolean save(Pentanahan pentanahan,Context context) {
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nilai_arrester",pentanahan.getNilaiArrester());
        contentValues.put("nilai_netral",pentanahan.getNilaiNetral());
        contentValues.put("nilai_body_trafo",pentanahan.getNilaiBodyTrafo());
        contentValues.put("nilai_tr_ujung",pentanahan.getNilaiTrUjung());
        contentValues.put("kondisi_netral",pentanahan.getKondisiNetral());
        contentValues.put("kondisi_arrester",pentanahan.getKondisiArrester());
        contentValues.put("kondisi_body_trafo",pentanahan.getKondisiBodyTrafo());
        contentValues.put("kondisi_tr_ujung",pentanahan.getNilaiTrUjung());
        contentValues.put("id_gardu", pentanahan.getGardu().getId());
        long insertedId = db.insert("pentanahan",null,contentValues);
        if(insertedId != -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Pentanahan pentanahan, Context context) {
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nilai_arrester",pentanahan.getNilaiArrester());
        contentValues.put("nilai_netral",pentanahan.getNilaiNetral());
        contentValues.put("nilai_body_trafo",pentanahan.getNilaiBodyTrafo());
        contentValues.put("nilai_tr_ujung",pentanahan.getNilaiTrUjung());
        contentValues.put("kondisi_netral",pentanahan.getKondisiNetral());
        contentValues.put("kondisi_arrester",pentanahan.getKondisiArrester());
        contentValues.put("kondisi_body_trafo",pentanahan.getKondisiBodyTrafo());
        contentValues.put("kondisi_tr_ujung",pentanahan.getNilaiTrUjung());
        contentValues.put("id_gardu", pentanahan.getGardu().getId());
        String where = "id = ?";
        String[] whereArgs = { String.valueOf(pentanahan.getId())};
        boolean updateSuccessful = db.update("pentanahan", contentValues, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;
    }

    @Override
    public List<Pentanahan> getAllData(Context context) {
        List<Pentanahan> data = new ArrayList<>();
//        try{
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        db.execSQL("delete from pentanahan");
        cursor = db.rawQuery("SELECT a.*, b.* FROM pentanahan a inner join gardu b on a.id_gardu = b.id ",null);
        cursor.moveToFirst();
        for(int i = 0; i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            Pentanahan pentanahan = new Pentanahan();
            Gardu gardu = new Gardu();
            pentanahan.setId(Integer.valueOf(cursor.getString(0).toString()));
            pentanahan.setNilaiNetral(cursor.getString(2).toString());
            pentanahan.setNilaiArrester(cursor.getString(3).toString());
            pentanahan.setNilaiBodyTrafo(cursor.getString(4).toString());
            pentanahan.setNilaiTrUjung(cursor.getString(5).toString());
            pentanahan.setKondisiNetral(cursor.getString(6).toString());
            pentanahan.setKondisiArrester(cursor.getString(7).toString());
            pentanahan.setKondisiBodyTrafo(cursor.getString(8).toString());
            pentanahan.setKondisiTrUjung(cursor.getString(9).toString());
            gardu.setId(cursor.getString(1).toString());
            gardu.setNomorGardu(cursor.getString(10).toString());
            gardu.setAlamat(cursor.getString(11).toString());
            pentanahan.setGardu(gardu);
            data.add(pentanahan);
        }
        return data;
    }
}
