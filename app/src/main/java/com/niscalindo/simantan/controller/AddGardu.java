package com.niscalindo.simantan.controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by USER on 2/1/2018.
 */
public class AddGardu extends AppCompatActivity {
    private EditText nomorGardu, alamat, kapasitasTrafo, penyulang;
    private EditText merkTrafo, tapTrafo, jumlahJurusan, konstruksi, tanggalUkur;
    private EditText jamUkur, petugas, koordinat;
    private Button saveButton, mapButton;
    private Spinner waktu;
    private GarduDao garduDao;
    private Context context;
    private Gardu garduMap;
    public DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gardu);
        garduDao = new GarduDaoImpl();
        context = this;
        init();
        if(getIntent().hasExtra("GARDU_AND_MAP")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_AND_MAP");
            fillData(garduMap);
        }
    }
    public void fillData(Gardu gardu){
        nomorGardu.setText(gardu.getNomorGardu());
        alamat.setText(gardu.getAlamat());
        kapasitasTrafo.setText(gardu.getKapasitasTrafo());
        penyulang.setText(gardu.getPenyulang());
        merkTrafo.setText(gardu.getMerkTrafo());
        tapTrafo.setText(gardu.getTapTrafo());
        jumlahJurusan.setText(gardu.getJumlahJurusan());
        konstruksi.setText(gardu.getKonstruksi());
        tanggalUkur.setText(gardu.getTanggalUkur());
        jamUkur.setText(gardu.getJamUkur());
        petugas.setText(gardu.getPetugas());
    }
    public void init(){
        nomorGardu =((EditText)findViewById(R.id.nomorGardu));
        alamat = ((EditText)findViewById(R.id.alamat));
        kapasitasTrafo = ((EditText)findViewById(R.id.kapasitasTrafo));
        penyulang = ((EditText)findViewById(R.id.penyulang));
        merkTrafo = ((EditText)findViewById(R.id.merkTrafo));
        tapTrafo = ((EditText)findViewById(R.id.tapTrafo));
        jumlahJurusan = ((EditText)findViewById(R.id.jumlahJurusan));
        konstruksi = ((EditText)findViewById(R.id.konstruksi));
        tanggalUkur = ((EditText)findViewById(R.id.tanggalUkur));
        jamUkur = ((EditText)findViewById(R.id.jamUkur));
        petugas = ((EditText)findViewById(R.id.petugas));
        waktu = ((Spinner)findViewById(R.id.waktu));

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(nomorGardu.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Data Nomor Gardu", Toast.LENGTH_SHORT).show();
                        }else if(alamat.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Alamat", Toast.LENGTH_SHORT).show();
                        }else if(kapasitasTrafo.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kapasitas Trafo", Toast.LENGTH_SHORT).show();
                        }else if(penyulang.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Penyulang", Toast.LENGTH_SHORT).show();
                        }else if(merkTrafo.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Merk", Toast.LENGTH_SHORT).show();
                        }else if(tapTrafo.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tap Trafo", Toast.LENGTH_SHORT).show();
                        }else if(jumlahJurusan.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Tap Jumlah Jurusan", Toast.LENGTH_SHORT).show();
                        }else if(konstruksi.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Konstruksi", Toast.LENGTH_SHORT).show();
                        }else if(tanggalUkur.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tanggal", Toast.LENGTH_SHORT).show();
                        }else if(jamUkur.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Jam", Toast.LENGTH_SHORT).show();
                        }else if(petugas.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Petugas", Toast.LENGTH_SHORT).show();
                        }else if(garduMap == null){
                            Toast.makeText(context, "Mohon Pilih Map", Toast.LENGTH_SHORT).show();
                        }else if(garduMap.getLatitude().equals("")){
                            Toast.makeText(context, "Mohon Pilih Map", Toast.LENGTH_SHORT).show();
                        }else if(garduMap.getLongitude().equals("")){
                            Toast.makeText(context, "Mohon Pilih Map", Toast.LENGTH_SHORT).show();
                        }else if(waktu.getSelectedItem().toString().equals("")){
                            Toast.makeText(context, "Isi waktu", Toast.LENGTH_SHORT).show();
                        }else {
                            Gardu gardu = new Gardu();
                            gardu.setNomorGardu(nomorGardu.getText().toString());
                            gardu.setAlamat(alamat.getText().toString());
                            gardu.setKapasitasTrafo(kapasitasTrafo.getText().toString());
                            gardu.setPenyulang(penyulang.getText().toString());
                            gardu.setMerkTrafo(merkTrafo.getText().toString());
                            gardu.setTapTrafo(tapTrafo.getText().toString());
                            gardu.setJumlahJurusan(jumlahJurusan.getText().toString());
                            gardu.setKonstruksi(konstruksi.getText().toString());
                            gardu.setTanggalUkur(tanggalUkur.getText().toString());
                            gardu.setJamUkur(jamUkur.getText().toString());
                            gardu.setPetugas(petugas.getText().toString());
                            gardu.setLongitude(garduMap.getLongitude());
                            gardu.setLatitude(garduMap.getLatitude());
                            gardu.setWaktu(waktu.getSelectedItem().toString());
                            Intent intent = new Intent("com.niscalindo.simantan.controller.TeganganBeban");
                            intent.putExtra("GARDU_SESSION", (Serializable) gardu);
                            startActivity(intent);

                        }

                    }
                }
        );
        mapButton = (Button)findViewById(R.id.openMap);
        mapButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(nomorGardu.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Data Nomor Gardu", Toast.LENGTH_SHORT).show();
                        }else if(alamat.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Alamat", Toast.LENGTH_SHORT).show();
                        }else if(kapasitasTrafo.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kapasitas Trafo", Toast.LENGTH_SHORT).show();
                        }else if(penyulang.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Penyulang", Toast.LENGTH_SHORT).show();
                        }else if(merkTrafo.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Merk", Toast.LENGTH_SHORT).show();
                        }else if(tapTrafo.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tap Trafo", Toast.LENGTH_SHORT).show();
                        }else if(jumlahJurusan.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Tap Jumlah Jurusan", Toast.LENGTH_SHORT).show();
                        }else if(konstruksi.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Konstruksi", Toast.LENGTH_SHORT).show();
                        }else if(tanggalUkur.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tanggal", Toast.LENGTH_SHORT).show();
                        }else if(jamUkur.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Jam", Toast.LENGTH_SHORT).show();
                        }else if(petugas.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Petugas", Toast.LENGTH_SHORT).show();
                        }else{
                            Gardu gardu = new Gardu();
                            gardu.setNomorGardu(nomorGardu.getText().toString());
                            gardu.setAlamat(alamat.getText().toString());
                            gardu.setKapasitasTrafo(kapasitasTrafo.getText().toString());
                            gardu.setPenyulang(penyulang.getText().toString());
                            gardu.setMerkTrafo(merkTrafo.getText().toString());
                            gardu.setTapTrafo(tapTrafo.getText().toString());
                            gardu.setJumlahJurusan(jumlahJurusan.getText().toString());
                            gardu.setKonstruksi(konstruksi.getText().toString());
                            gardu.setTanggalUkur(tanggalUkur.getText().toString());
                            gardu.setJamUkur(jamUkur.getText().toString());
                            gardu.setPetugas(petugas.getText().toString());
                            Intent intent = new Intent("com.niscalindo.simantan.controller.MapController");
                            intent.putExtra("GARDU_SESSION", (Serializable) gardu);
                            intent.putExtra("SESSION", "ADD");
                            startActivity(intent);
                        }

                    }
                }
        );
        tanggalUkur.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    final Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(AddGardu.this,new DatePickerDialog.OnDateSetListener(){
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            tanggalUkur.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);

                        }
                    },year,month, day);
                    datePickerDialog.show();
                }
            }

//            @Override
//            public void onClick(View v) {
//
//            }
        });
    }
}
