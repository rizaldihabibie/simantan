package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;

/**
 * Created by USER on 2/1/2018.
 */
public class AddGardu extends AppCompatActivity {
    private EditText nomorGardu, alamat, kapasitasTrafo, penyulang;
    private EditText merkTrafo, tapTrafo, jumlahJurusan, konstruksi, tanggalUkur;
    private EditText jamUkur, petugas, koordinat;
    private Button saveButton, mapButton;
    private GarduDao garduDao;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gardu);
        garduDao = new GarduDaoImpl();
        context = this;
        saveAction();
    }

    public void saveAction(){
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
//        koordinat = ((EditText)findViewById(R.id.koordinat));

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
//                        gardu.setKoordinat(koordinat.getText().toString());
                        boolean success = garduDao.saveGardu(gardu,context);
                        if(success){
                            Intent intent = new Intent("com.niscalindo.simantan.controller.GarduPage");
                            startActivity(intent);
                        }else{
                            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        mapButton = (Button)findViewById(R.id.openMap);
        mapButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent("com.niscalindo.simantan.controller.MapController");
                            startActivity(intent);
                    }
                }
        );
    }
}
