package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;

/**
 * Created by USER on 2/9/2018.
 */
public class ViewDataGardu extends AppCompatActivity {
    private EditText nomorGardu, alamat, kapasitasTrafo, penyulang;
    private EditText merkTrafo, tapTrafo, jumlahJurusan, konstruksi, tanggalUkur;
    private EditText jamUkur, petugas, koordinat;
    private Button editButton, mapButton;
    private GarduDao garduDao;
    private Context context;
    private Gardu garduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gardu);
        garduDao = new GarduDaoImpl();
        context = this;
        init();
        if(getIntent().hasExtra("GARDU_DATA_SESSION")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_DATA_SESSION");
            fillData(garduMap);
        }
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
        mapButton = (Button)findViewById(R.id.mapButton);
        editButton = (Button)findViewById(R.id.editButton);
        mapButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.ViewMapController");
                        intent.putExtra("GARDU_DATA_SESSION", (Serializable) garduMap);
                        startActivity(intent);
                    }
                }
        );
        editButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.EditGardu");
                        intent.putExtra("GARDU_DATA_SESSION", (Serializable) garduMap);
                        startActivity(intent);
                    }
                }
        );

    }
    public void fillData(Gardu gardu){
        nomorGardu.setText(gardu.getNomorGardu());
        nomorGardu.setEnabled(false);
        alamat.setText(gardu.getAlamat());
        alamat.setEnabled(false);
        kapasitasTrafo.setText(gardu.getKapasitasTrafo());
        kapasitasTrafo.setEnabled(false);
        penyulang.setText(gardu.getPenyulang());
        penyulang.setEnabled(false);
        merkTrafo.setText(gardu.getMerkTrafo());
        merkTrafo.setEnabled(false);
        tapTrafo.setText(gardu.getTapTrafo());
        tapTrafo.setEnabled(false);
        jumlahJurusan.setText(gardu.getJumlahJurusan());
        jumlahJurusan.setEnabled(false);
        konstruksi.setText(gardu.getKonstruksi());
        konstruksi.setEnabled(false);
        tanggalUkur.setText(gardu.getTanggalUkur());
        tanggalUkur.setEnabled(false);
        jamUkur.setText(gardu.getJamUkur());
        jamUkur.setEnabled(false);
        petugas.setText(gardu.getPetugas());
        petugas.setEnabled(false);
    }
}
