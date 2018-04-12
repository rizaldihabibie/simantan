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
import android.widget.Toast;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by USER on 3/12/2018.
 */
public class EditUkuranLain extends AppCompatActivity {
    private Gardu garduMap;
    private Button backButton, saveButton;
    private EditText fuseAr, fuseAs, fuseAt;
    private EditText fuseBr, fuseBs, fuseBt;
    private EditText fuseCr, fuseCs, fuseCt;
    private EditText fuseDr, fuseDs, fuseDt;
    private EditText noSeri, tglPasang, tglGanti;
    private Context context;
    private GarduDao garduDao;
    public DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ukuran_lain_lain);
        context = this;
        garduDao = new GarduDaoImpl();
        init();
        if(getIntent().hasExtra("GARDU_SESSION")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_SESSION");
            fillData(garduMap);
        }
        back();
        save();
    }

    public void init(){
        backButton = (Button)findViewById(R.id.backButton);
        saveButton = (Button)findViewById(R.id.saveButton);
        fuseAr = (EditText)findViewById(R.id.a_r);
        fuseAs = (EditText)findViewById(R.id.a_s);
        fuseAt = (EditText)findViewById(R.id.a_t);
        fuseBr = (EditText)findViewById(R.id.b_r);
        fuseBs = (EditText)findViewById(R.id.b_s);
        fuseBt = (EditText)findViewById(R.id.b_t);
        fuseCr = (EditText)findViewById(R.id.c_r);
        fuseCs = (EditText)findViewById(R.id.c_s);
        fuseCt = (EditText)findViewById(R.id.c_t);
        fuseDr = (EditText)findViewById(R.id.d_r);
        fuseDs = (EditText)findViewById(R.id.d_s);
        fuseDt = (EditText)findViewById(R.id.d_t);
        noSeri = (EditText)findViewById(R.id.nomorSeri);
        tglGanti = (EditText)findViewById(R.id.tanggalGanti);
        tglPasang = (EditText)findViewById(R.id.tanggalPasang);
        tglPasang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    final Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(EditUkuranLain.this,new DatePickerDialog.OnDateSetListener(){
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            tglPasang.setText(dayOfMonth + "/"
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
        tglGanti.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    final Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePickerDialog = new DatePickerDialog(EditUkuranLain.this,new DatePickerDialog.OnDateSetListener(){
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            tglGanti.setText(dayOfMonth + "/"
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
    public void fillData(Gardu gardu){
        fuseAr.setText(gardu.getFuseAr());
        fuseAs.setText(gardu.getFuseAs());
        fuseAt.setText(gardu.getFuseAt());
        fuseBr.setText(gardu.getFuseBr());
        fuseBs.setText(gardu.getFuseBs());
        fuseBt.setText(gardu.getFuseBt());
        fuseCr.setText(gardu.getFuseCr());
        fuseCs.setText(gardu.getFuseCs());
        fuseCt.setText(gardu.getFuseCt());
        fuseDr.setText(gardu.getFuseDr());
        fuseDs.setText(gardu.getFuseDs());
        fuseDt.setText(gardu.getFuseDt());
        noSeri.setText(gardu.getNoSeri());
        tglGanti.setText(gardu.getTanggalGanti());
        tglPasang.setText(gardu.getTanggalPasang());
    }
    public void back(){
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.EditTeganganBeban");
                        intent.putExtra("GARDU_SESSION", (Serializable) garduMap);
                        startActivity(intent);
                    }


                }
        );

    }
    public void save(){
        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(fuseAr.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris A ", Toast.LENGTH_SHORT).show();
                        }else if(fuseAs.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris A", Toast.LENGTH_SHORT).show();
                        }else if(fuseAt.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris A", Toast.LENGTH_SHORT).show();
                        }else if(fuseBr.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris B", Toast.LENGTH_SHORT).show();
                        }else if(fuseBs.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris B", Toast.LENGTH_SHORT).show();
                        }else if(fuseBt.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris B", Toast.LENGTH_SHORT).show();
                        }else if(fuseCr.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris C", Toast.LENGTH_SHORT).show();
                        }else if(fuseCs.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris C", Toast.LENGTH_SHORT).show();
                        }else if(fuseCt.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris C", Toast.LENGTH_SHORT).show();
                        }else if(fuseDr.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris D", Toast.LENGTH_SHORT).show();
                        }else if(fuseDs.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris D", Toast.LENGTH_SHORT).show();
                        }else if(fuseDt.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris D", Toast.LENGTH_SHORT).show();
                        }else if(noSeri.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Nomor Seri", Toast.LENGTH_SHORT).show();
                        }else if(tglPasang.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tanggal Pasang", Toast.LENGTH_SHORT).show();
                        }else if(tglGanti.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Tanggal Ganti", Toast.LENGTH_SHORT).show();
                        }else {
                            garduMap.setFuseAr(fuseAr.getText().toString());
                            garduMap.setFuseAs(fuseAs.getText().toString());
                            garduMap.setFuseAt(fuseAt.getText().toString());
                            garduMap.setFuseBr(fuseBr.getText().toString());
                            garduMap.setFuseBs(fuseBs.getText().toString());
                            garduMap.setFuseBt(fuseBt.getText().toString());
                            garduMap.setFuseCr(fuseCr.getText().toString());
                            garduMap.setFuseCs(fuseCs.getText().toString());
                            garduMap.setFuseCt(fuseCt.getText().toString());
                            garduMap.setFuseDr(fuseDr.getText().toString());
                            garduMap.setFuseDs(fuseDs.getText().toString());
                            garduMap.setFuseDt(fuseDt.getText().toString());
                            garduMap.setNoSeri(noSeri.getText().toString());
                            garduMap.setTanggalGanti(tglGanti.getText().toString());
                            garduMap.setTanggalPasang(tglPasang.getText().toString());
                            boolean success = garduDao.updateGardu(garduMap,context);
                            if(success){
                                Intent intent = new Intent("com.niscalindo.simantan.controller.ContentGardu");
                                startActivity(intent);
                            }else{
                                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
        );

    }
}
