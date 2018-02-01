package com.niscalindo.simantan.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by USER on 1/30/2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    static final String DATABASE_NAME = "simantan.db";
    public static final String TABEL_GARDU = "gardu";
    public static final String COLUMN_ID = "id";
    public static final String NOMOR_GARDU = "nomor_gardu";
    public static final String ALAMAT = "alamat";
    public static final String KAPASITAS_TRAFO = "kapasitas_trafo";
    public static final String PENYULANG = "penyulang";
    public static final String MERK_TRAFO = "merk_trafo";
    public static final String TAP_TRAFO = "tap_trafo";
    public static final String JUMLAH_JURUSAN = "jumlah_jurusan";
    public static final String KONSTRUKSI = "konstruksi";
    public static final String TANGGAL_UKUR = "tanggal_ukur";
    public static final String PETUGAS = "petugas";
    public static final String KOORDINAT = "koordinat";

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

        final String CREATE_GARDU_TABLE = "CREATE gardu credential (" +
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
                "koordinat VARCHAR(250))";
        db.execSQL(CREATE_GARDU_TABLE);

        final String INSERT_FIRST_ROW = "INSERT INTO credential (username, password) values ('habibie@admin.com','qwerty123')";
        db.execSQL(INSERT_FIRST_ROW);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS credential ");
//        onCreate(db);
    }

}

