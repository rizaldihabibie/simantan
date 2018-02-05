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

    /** Field 1 of the table locations, which is the primary key */
    public static final String FIELD_ROW_ID = "_id";

    /** Field 2 of the table locations, stores the latitude */
    public static final String FIELD_LAT = "lat";

    /** Field 3 of the table locations, stores the longitude*/
    public static final String FIELD_LNG = "lng";

    /** Field 4 of the table locations, stores the zoom level of map*/
    public static final String FIELD_ZOOM = "zom";

    /** A constant, stores the the table name */
    private static final String DATABASE_TABLE = "locations";


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
                "koordinat VARCHAR(250))";
        db.execSQL(CREATE_GARDU_TABLE);

        final String INSERT_FIRST_ROW = "INSERT INTO credential (username, password) values ('habibie@admin.com','qwerty123')";
        db.execSQL(INSERT_FIRST_ROW);

        final String CREATE_MAP_TABLE =     "create table " + DATABASE_TABLE + " ( " +
                FIELD_ROW_ID + " integer primary key autoincrement , " +
                FIELD_LNG + " double , " +
                FIELD_LAT + " double , " +
                FIELD_ZOOM + " text " +
                " ) ";

        db.execSQL(CREATE_MAP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS credential ");
        db.execSQL("DROP TABLE IF EXISTS gardu ");
        onCreate(db);
    }

}

