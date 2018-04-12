package com.niscalindo.simantan.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.PentanahanDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.dao.dao.impl.PentanahanDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;
import com.niscalindo.simantan.database.model.Pentanahan;

import java.util.List;

/**
 * Created by USER on 4/7/2018.
 */
public class ViewPentanahan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<Gardu> data;
    private GarduDao garduDao;
    private EditText nilaiNetral, nilaiArrester, nilaiBodyTrafo, nilaiTrUjung;
    private EditText kondisiNetral, kondisiArrester, kondisiBodyTrafo, kondisiTrUjung;
    private EditText alamat, petugas, tanggalUkur,penyulang;
    private Button saveButton;
    private Context context;
    private Gardu gardu;
    private PentanahanDao pentanahanDao;
    private Pentanahan pentanahan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pentanahan);
        context = this;
        garduDao = new GarduDaoImpl();
        pentanahanDao = new PentanahanDaoImpl();
        data = garduDao.getAllData(this);
        init();
        if(getIntent().hasExtra("PENTANAHAN_SESSION")){
            pentanahan = (Pentanahan) getIntent().getSerializableExtra("PENTANAHAN_SESSION");

            fillData(pentanahan);
        }
        String[] noGardu = new String[data.size()];
        int garduSelected = 0;
        for(int i=0; i<data.size();i++){
            noGardu[i] = data.get(i).getNomorGardu();
            if(pentanahan.getGardu().getId().equals(data.get(i).getId())){
                garduSelected = i;
            }
        }
//        String[] negara = { "Amerika", "Argentina", "Brazil", "Indonesia",
//                "Inggris", "Malaysia", "Pilipina" };
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, noGardu);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setSelection(garduSelected);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        gardu = data.get(position);
        alamat.setText(gardu.getAlamat());
        tanggalUkur.setText(gardu.getTanggalUkur());
        petugas.setText(gardu.getPetugas());
        penyulang.setText(gardu.getPenyulang());
        alamat.setEnabled(false);
        petugas.setEnabled(false);
        penyulang.setEnabled(false);
        tanggalUkur.setEnabled(false);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void init(){
        nilaiNetral = (EditText)findViewById(R.id.nilai_netral);
        nilaiArrester = (EditText)findViewById(R.id.nilai_arrester);
        nilaiBodyTrafo = (EditText)findViewById(R.id.nilai_body_trafo);
        nilaiTrUjung = (EditText)findViewById(R.id.nilai_tr_ujung);
        kondisiNetral = (EditText)findViewById(R.id.kondisi_netral);
        kondisiArrester = (EditText)findViewById(R.id.kondisi_arrester);
        kondisiBodyTrafo = (EditText)findViewById(R.id.kondisi_body_trafo);
        kondisiTrUjung = (EditText)findViewById(R.id.kondisi_tr_ujung);
        alamat = (EditText)findViewById(R.id.alamat);
        penyulang = (EditText)findViewById(R.id.penyulang);
        petugas = (EditText)findViewById(R.id.petugas);
        tanggalUkur = (EditText)findViewById(R.id.tanggalUkur);
        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setVisibility(View.INVISIBLE);
//        saveButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(nilaiNetral.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi Data Nilai Netral", Toast.LENGTH_SHORT).show();
//                        }else if(nilaiArrester.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi Nilai Arrester", Toast.LENGTH_SHORT).show();
//                        }else if(nilaiBodyTrafo.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi Nila Body Trafo", Toast.LENGTH_SHORT).show();
//                        }else if(nilaiTrUjung.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi nilai TR Ujung", Toast.LENGTH_SHORT).show();
//                        }else if(kondisiNetral.getText().equals("")){
//                            Toast.makeText(context, "Mohon Isi Kondisi Netral", Toast.LENGTH_SHORT).show();
//                        }else if(kondisiArrester.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi Kondisi Arrester", Toast.LENGTH_SHORT).show();
//                        }else if(kondisiBodyTrafo.getText().equals("")){
//                            Toast.makeText(context, "Mohon Isi kondisi Body Trafo", Toast.LENGTH_SHORT).show();
//                        }else if(kondisiTrUjung.getText().toString().equals("")){
//                            Toast.makeText(context, "Mohon Isi kondisi TR Ujung", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Pentanahan pentanahan = new Pentanahan();
//                            pentanahan.setGardu(gardu);
//                            pentanahan.setNilaiNetral(nilaiNetral.getText().toString());
//                            pentanahan.setNilaiArrester(nilaiArrester.getText().toString());
//                            pentanahan.setNilaiBodyTrafo(nilaiBodyTrafo.getText().toString());
//                            pentanahan.setNilaiTrUjung(nilaiTrUjung.getText().toString());
//                            pentanahan.setKondisiNetral(kondisiNetral.getText().toString());
//                            pentanahan.setKondisiArrester(kondisiArrester.getText().toString());
//                            pentanahan.setKondisiBodyTrafo(kondisiBodyTrafo.getText().toString());
//                            pentanahan.setKondisiTrUjung(kondisiTrUjung.getText().toString());
//                            if(pentanahanDao.save(pentanahan, context)){
//                                Intent intent = new Intent("com.niscalindo.simantan.controller.ContentPentanahan");
//                                startActivity(intent);
//                            }else{
//                                Toast.makeText(context, "Something Went Wrong !!",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                    }
//                }
//        );
    }
    public void fillData(Pentanahan pentanahan){
        nilaiNetral.setText(pentanahan.getNilaiNetral());
        nilaiArrester.setText(pentanahan.getNilaiArrester());
        nilaiBodyTrafo.setText(pentanahan.getNilaiBodyTrafo());
        nilaiTrUjung.setText(pentanahan.getNilaiTrUjung());
        kondisiNetral.setText(pentanahan.getKondisiNetral());
        kondisiArrester.setText(pentanahan.getKondisiArrester());
        kondisiBodyTrafo.setText(pentanahan.getKondisiBodyTrafo());
        kondisiTrUjung.setText(pentanahan.getNilaiTrUjung());
        nilaiNetral.setEnabled(false);
        nilaiArrester.setEnabled(false);
        nilaiBodyTrafo.setEnabled(false);
        nilaiTrUjung.setEnabled(false);
        kondisiArrester.setEnabled(false);
        kondisiNetral.setEnabled(false);
        kondisiBodyTrafo.setEnabled(false);
        kondisiTrUjung.setEnabled(false);
    }
}
