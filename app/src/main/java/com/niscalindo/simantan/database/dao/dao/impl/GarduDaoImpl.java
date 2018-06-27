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
        contentValues.put("r_n",gardu.getRn());
        contentValues.put("r_s",gardu.getRs());
        contentValues.put("s_n",gardu.getSn());
        contentValues.put("r_t",gardu.getRt());
        contentValues.put("t_n",gardu.getTn());
        contentValues.put("s_t",gardu.getSt());
        contentValues.put("a_r",gardu.getAr());
        contentValues.put("a_s",gardu.getAs());
        contentValues.put("a_t",gardu.getAt());
        contentValues.put("a_n",gardu.getBn());
        contentValues.put("b_r",gardu.getBr());
        contentValues.put("b_s",gardu.getBs());
        contentValues.put("b_t",gardu.getBt());
        contentValues.put("b_n",gardu.getBn());
        contentValues.put("c_r",gardu.getCr());
        contentValues.put("c_s",gardu.getCs());
        contentValues.put("c_t",gardu.getCt());
        contentValues.put("c_n",gardu.getCn());
        contentValues.put("d_r",gardu.getDr());
        contentValues.put("d_s",gardu.getDs());
        contentValues.put("d_t",gardu.getDt());
        contentValues.put("d_n",gardu.getDn());
        contentValues.put("fuse_a_r",gardu.getFuseAr());
        contentValues.put("fuse_a_s",gardu.getFuseAs());
        contentValues.put("fuse_a_t",gardu.getFuseAt());
        contentValues.put("fuse_b_r",gardu.getFuseBr());
        contentValues.put("fuse_b_s",gardu.getFuseBs());
        contentValues.put("fuse_b_t",gardu.getFuseBt());
        contentValues.put("fuse_c_r",gardu.getFuseCr());
        contentValues.put("fuse_c_s",gardu.getFuseCs());
        contentValues.put("fuse_c_t",gardu.getFuseCt());
        contentValues.put("fuse_d_r",gardu.getFuseDr());
        contentValues.put("fuse_d_s",gardu.getFuseDs());
        contentValues.put("fuse_d_t",gardu.getFuseDt());
        contentValues.put("no_seri",gardu.getNoSeri());
        contentValues.put("tanggal_pasang",gardu.getTanggalPasang());
        contentValues.put("tanggal_ganti",gardu.getTanggalGanti());
        contentValues.put("waktu",gardu.getWaktu());
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
            gardu.setRn(cursor.getString(15).toString());
            gardu.setRs(cursor.getString(16).toString());
            gardu.setSn(cursor.getString(17).toString());
            gardu.setRt(cursor.getString(18).toString());
            gardu.setTn(cursor.getString(19).toString());
            gardu.setSt(cursor.getString(20).toString());
            gardu.setAr(cursor.getString(21).toString());
            gardu.setAs(cursor.getString(22).toString());
            gardu.setAt(cursor.getString(23).toString());
            gardu.setAn(cursor.getString(24).toString());
            gardu.setBr(cursor.getString(25).toString());
            gardu.setBs(cursor.getString(26).toString());
            gardu.setBt(cursor.getString(27).toString());
            gardu.setBn(cursor.getString(28).toString());
            gardu.setCr(cursor.getString(29).toString());
            gardu.setCs(cursor.getString(30).toString());
            gardu.setCt(cursor.getString(31).toString());
            gardu.setCn(cursor.getString(32).toString());
            gardu.setDr(cursor.getString(33).toString());
            gardu.setDs(cursor.getString(34).toString());
            gardu.setDt(cursor.getString(35).toString());
            gardu.setDn(cursor.getString(36).toString());
            gardu.setFuseAr(cursor.getString(37).toString());
            gardu.setFuseAs(cursor.getString(38).toString());
            gardu.setFuseAt(cursor.getString(39).toString());
            gardu.setFuseBr(cursor.getString(40).toString());
            gardu.setFuseBs(cursor.getString(41).toString());
            gardu.setFuseBt(cursor.getString(42).toString());
            gardu.setFuseCr(cursor.getString(43).toString());
            gardu.setFuseCs(cursor.getString(44).toString());
            gardu.setFuseCt(cursor.getString(45).toString());
            gardu.setFuseDr(cursor.getString(46).toString());
            gardu.setFuseDs(cursor.getString(47).toString());
            gardu.setFuseDt(cursor.getString(48).toString());
            gardu.setNoSeri(cursor.getString(49).toString());
            gardu.setTanggalPasang(cursor.getString(50).toString());
            gardu.setTanggalGanti(cursor.getString(51).toString());
            gardu.setWaktu(cursor.getString(52).toString());
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
        contentValues.put("r_n",gardu.getRn());
        contentValues.put("r_s",gardu.getRs());
        contentValues.put("s_n",gardu.getSn());
        contentValues.put("r_t",gardu.getRt());
        contentValues.put("t_n",gardu.getTn());
        contentValues.put("s_t",gardu.getSt());
        contentValues.put("a_r",gardu.getAr());
        contentValues.put("a_s",gardu.getAs());
        contentValues.put("a_t",gardu.getAt());
        contentValues.put("a_n",gardu.getBn());
        contentValues.put("b_r",gardu.getBr());
        contentValues.put("b_s",gardu.getBs());
        contentValues.put("b_t",gardu.getBt());
        contentValues.put("b_n",gardu.getBn());
        contentValues.put("c_r",gardu.getCr());
        contentValues.put("c_s",gardu.getCs());
        contentValues.put("c_t",gardu.getCt());
        contentValues.put("c_n",gardu.getCn());
        contentValues.put("d_r",gardu.getDr());
        contentValues.put("d_s",gardu.getDs());
        contentValues.put("d_t",gardu.getDt());
        contentValues.put("d_n",gardu.getDn());
        contentValues.put("fuse_a_r",gardu.getFuseAr());
        contentValues.put("fuse_a_s",gardu.getFuseAs());
        contentValues.put("fuse_a_t",gardu.getFuseAt());
        contentValues.put("fuse_b_r",gardu.getFuseBr());
        contentValues.put("fuse_b_s",gardu.getFuseBs());
        contentValues.put("fuse_b_t",gardu.getFuseBt());
        contentValues.put("fuse_c_r",gardu.getFuseCr());
        contentValues.put("fuse_c_s",gardu.getFuseCs());
        contentValues.put("fuse_c_t",gardu.getFuseCt());
        contentValues.put("fuse_d_r",gardu.getFuseDr());
        contentValues.put("fuse_d_s",gardu.getFuseDs());
        contentValues.put("fuse_d_t",gardu.getFuseDt());
        contentValues.put("no_seri",gardu.getNoSeri());
        contentValues.put("tanggal_pasang",gardu.getTanggalPasang());
        contentValues.put("tanggal_ganti",gardu.getTanggalGanti());
        contentValues.put("waktu",gardu.getWaktu());

        String where = "id = ?";

        String[] whereArgs = { gardu.getId()};
        boolean updateSuccessful = db.update("gardu", contentValues, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;
    }

    @Override
    public boolean deleteData(String id, Context context)
    {
        boolean deleteSuccess;
        dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        deleteSuccess = db.delete("gardu","id =" + id, null) > 0;
        if(deleteSuccess){
            deleteSuccess = db.delete("pentanahan","id_gardu = " + id, null)>0;
            return deleteSuccess;
        }else{
            return false;
        }

    }
}
