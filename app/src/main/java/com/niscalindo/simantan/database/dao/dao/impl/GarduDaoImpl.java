package com.niscalindo.simantan.database.dao.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.helper.DatabaseHelper;
import com.niscalindo.simantan.database.model.Gardu;

/**
 * Created by USER on 2/1/2018.
 */
public class GarduDaoImpl implements GarduDao {
    private Cursor cursor;
    private DatabaseHelper dbHelper;
    @Override
    public boolean saveGardu(Gardu gardu,Context context) {
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomor_gardu",gardu.getNomorGardu());
        contentValues.put("alamat",gardu.getAlamat());
        contentValues.put("kapasitas_trafo",gardu.getKapasitasTrafo());
        contentValues.put("penyulang",gardu.getPenyulang());
        contentValues.put("merk_trafo",gardu.getMerkTrafo());
        contentValues.put("tap_trafo",gardu.getTapTrafo());
        contentValues.put("jumlah_jurusan",gardu.getJumlahJurusan());
        contentValues.put("konstruksi",gardu.getKonstruksi());
        contentValues.put("tanggal_ukur", gardu.getTanggalUkur());
        contentValues.put("jam_ukur",gardu.getJamUkur());
        contentValues.put("petugas",gardu.getPetugas());
        contentValues.put("koordinat",gardu.getKoordinat());

//        db.execSQL("INSERT into gardu (nomor_gardu,alamat,kapasitas_trafo,penyulang,merk_trafo,tap_trafo,jumlah_jurusan,konstruksi,tanggal_ukur, jam_ukur,petugas,koordinat) VALUES (" +
//                "= '"+gardu.getNomorGardu()+"','"+gardu.getAlamat()+"','"+gardu.getKapasitasTrafo()+"','"+gardu.getPenyulang()+"','"+gardu.getMerkTrafo()+"','"+gardu.getTapTrafo()+"','"+gardu.getJumlahJurusan()+"','"+gardu.getKonstruksi()+"','"+gardu.getTanggalUkur()+"','"+gardu.getJamUkur()+"','"+gardu.getPetugas()+"','"+gardu.getKoordinat()+"",null);
        long insertedId = db.insert("gardu",null,contentValues);
        if(insertedId != -1){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public String[] getAllData(Context context) {
        String[] data = null;
//        try{
            dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM gardu",null);
            data = new String[cursor.getCount()];
            cursor.moveToFirst();
            for(int i = 0; i<cursor.getCount();i++){
                cursor.moveToPosition(i);
                data[i] = cursor.getString(1).toString();
            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        return data;
    }
}
