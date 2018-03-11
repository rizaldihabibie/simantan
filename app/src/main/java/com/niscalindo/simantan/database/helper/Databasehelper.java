package com.niscalindo.simantan.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 1/30/2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    static final String DATABASE_NAME = "simantan.db";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        final String CREATE_CREDENTIAL_TABLE = "CREATE TABLE credential (" +
                "id INTEGER PRIMARY KEY autoincrement," +
                "username VARCHAR(50)," +
                "password VARCHAR(50))";
        db.execSQL(CREATE_CREDENTIAL_TABLE);

        final String CREATE_GARDU_TABLE = "CREATE TABLE gardu (" +
                "id INTEGER PRIMARY KEY autoincrement," +
                "nomor_gardu VARCHAR(50)," +
                "alamat VARCHAR(250)," +
                "kapasitas_trafo VARCHAR(50)," +
                "penyulang VARCHAR(50)," +
                "merk_trafo VARCHAR(50)," +
                "tap_trafo VARCHAR(50)," +
                "jumlah_jurusan VARCHAR(50)," +
                "konstruksi VARCHAR(50)," +
                "tanggal_ukur VARCHAR(50)," +
                "jam_ukur VARCHAR(50)," +
                "petugas VARCHAR(100)," +
                "latitude double," +
                "langitude double," +
                "zoom text," +
                "r_n VARCHAR(20)," +
                "r_s VARCHAR(20)," +
                "s_n VARCHAR(20)," +
                "r_t VARCHAR(20)," +
                "t_n VARCHAR(20)," +
                "s_t VARCHAR(20)," +
                "a_r VARCHAR(20)," +
                "a_s VARCHAR(20)," +
                "a_t VARCHAR(20)," +
                "a_n VARCHAR(20)," +
                "b_r VARCHAR(20)," +
                "b_s VARCHAR(20)," +
                "b_t VARCHAR(20)," +
                "b_n VARCHAR(20)," +
                "c_r VARCHAR(20)," +
                "c_s VARCHAR(20)," +
                "c_t VARCHAR(20)," +
                "c_n VARCHAR(20)," +
                "d_r VARCHAR(20)," +
                "d_s VARCHAR(20)," +
                "d_t VARCHAR(20)," +
                "d_n VARCHAR(20)," +
                "fuse_a_r VARCHAR(20)," +
                "fuse_a_s VARCHAR(20)," +
                "fuse_a_t VARCHAR(20)," +
                "fuse_b_r VARCHAR(20)," +
                "fuse_b_s VARCHAR(20)," +
                "fuse_b_t VARCHAR(20)," +
                "fuse_c_r VARCHAR(20)," +
                "fuse_c_s VARCHAR(20)," +
                "fuse_c_t VARCHAR(20)," +
                "fuse_d_r VARCHAR(20)," +
                "fuse_d_s VARCHAR(20)," +
                "fuse_d_t VARCHAR(20)," +
                "no_seri VARCHAR(20)," +
                "tanggal_pasang VARCHAR(20)," +
                "tanggal_ganti VARCHAR(20))";
        db.execSQL(CREATE_GARDU_TABLE);

        final String INSERT_FIRST_ROW = "INSERT INTO credential (username, password) values ('habibie@admin.com','qwerty123')";
        db.execSQL(INSERT_FIRST_ROW);

//        final String CREATE_MAP_TABLE =     "create table " + DATABASE_TABLE + " ( " +
//                FIELD_ROW_ID + " integer primary key autoincrement , " +
//                FIELD_LNG + " double , " +
//                FIELD_LAT + " double , " +
//                FIELD_ZOOM + " text " +
//                " ) ";
//
//        db.execSQL(CREATE_MAP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS credential ");
        db.execSQL("DROP TABLE IF EXISTS gardu ");
        onCreate(db);
    }

}

