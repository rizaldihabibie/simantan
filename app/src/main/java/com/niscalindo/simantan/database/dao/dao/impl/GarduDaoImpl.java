package com.niscalindo.simantan.database.dao.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.helper.DatabaseHelper;
import com.niscalindo.simantan.database.model.Gardu;

import java.util.ArrayList;
import java.util.List;

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
        contentValues.put("latitude",gardu.getLatitude());
        contentValues.put("langitude",gardu.getLongitude());
        contentValues.put("zoom",gardu.getZoom());



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
    public String[] getAllStringData(Context context) {
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

    @Override
    public List<Gardu> getAllData(Context context) {
        List<Gardu> data = new ArrayList<>();
//        try{
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM gardu",null);
        cursor.moveToFirst();
        for(int i = 0; i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            Gardu gardu = new Gardu();
            gardu.setId(cursor.getString(0).toString());
            gardu.setNomorGardu(cursor.getString(1).toString());
            gardu.setAlamat(cursor.getString(2).toString());
            gardu.setKapasitasTrafo(cursor.getString(3).toString());
            gardu.setPenyulang(cursor.getString(4).toString());
            gardu.setMerkTrafo(cursor.getString(5).toString());
            gardu.setTapTrafo(cursor.getString(6).toString());
            gardu.setJumlahJurusan(cursor.getString(7).toString());
            gardu.setKonstruksi(cursor.getString(8).toString());
            gardu.setTanggalUkur(cursor.getString(9).toString());
            gardu.setJamUkur(cursor.getString(10).toString());
            gardu.setPetugas(cursor.getString(11).toString());
            gardu.setLatitude(Double.valueOf(cursor.getString(12).toString()));
            gardu.setLongitude(Double.valueOf(cursor.getString(13).toString()));
            gardu.setZoom(Float.valueOf(cursor.getString(14).toString()));
            data.add(gardu);

        }
        return data;

    }

    @Override
    public boolean updateGardu(Gardu gardu, Context context) {
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
        contentValues.put("latitude",gardu.getLatitude());
        contentValues.put("langitude",gardu.getLongitude());
        contentValues.put("zoom",gardu.getZoom());
        String where = "id = ?";

        String[] whereArgs = { gardu.getId()};
        boolean updateSuccessful = db.update("gardu", contentValues, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;
    }
}
