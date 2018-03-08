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

import java.io.Serializable;

/**
 * Created by USER on 3/3/2018.
 */
public class TeganganBeban extends AppCompatActivity {
    private GarduDao garduDao;
    private Context context;
    private Gardu garduMap;
    private EditText rN, rS, sN,rT,tN,sT;
    private EditText aR, aS, aT, aN;
    private EditText bR,bS, bT, bN;
    private EditText cR,cS, cT, cN;
    private EditText dR,dS, dT, dN;
    private Button nextButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tegangan_beban);
        garduDao = new GarduDaoImpl();
        context = this;
        init();
        if(getIntent().hasExtra("GARDU_SESSION")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_SESSION");
        }
        if(getIntent().hasExtra("GARDU_TEGANGAN")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_TEGANGAN");
            fillData(garduMap);
        }
        save();
        back();
    }
    public void fillData(Gardu gardu){
        rN.setText(gardu.getRn());
        rS.setText(gardu.getRs());
        sN.setText(gardu.getSn());
        rT.setText(gardu.getRt());
        tN.setText(gardu.getTn());
        sT.setText(gardu.getSt());
        aR.setText(gardu.getAr());
        aS.setText(gardu.getAs());
        aT.setText(gardu.getAt());
        aN.setText(gardu.getAn());
        bR.setText(gardu.getBr());
        bS.setText(gardu.getBs());
        bT.setText(gardu.getBt());
        bN.setText(gardu.getBn());
        cR.setText(gardu.getCr());
        cS.setText(gardu.getCs());
        cT.setText(gardu.getCt());
        cN.setText(gardu.getCn());
        dR.setText(gardu.getDr());
        dS.setText(gardu.getDs());
        dT.setText(gardu.getDt());
        dN.setText(gardu.getDn());
    }
    public void init(){
        nextButton = (Button)findViewById(R.id.saveButton);
        backButton = (Button)findViewById(R.id.backButton);
        rN = (EditText)findViewById(R.id.r_n);
        rS = (EditText)findViewById(R.id.r_s);
        sN = (EditText)findViewById(R.id.s_n);
        rT = (EditText)findViewById(R.id.r_t);
        tN = (EditText)findViewById(R.id.t_n);
        sT = (EditText)findViewById(R.id.s_t);
        aR = (EditText)findViewById(R.id.a_r);
        aS = (EditText)findViewById(R.id.a_s);
        aT = (EditText)findViewById(R.id.a_t);
        aN = (EditText)findViewById(R.id.a_n);
        bR = (EditText)findViewById(R.id.b_r);
        bS = (EditText)findViewById(R.id.b_s);
        bT = (EditText)findViewById(R.id.b_t);
        bN = (EditText)findViewById(R.id.b_n);
        cR = (EditText)findViewById(R.id.c_r);
        cS = (EditText)findViewById(R.id.c_s);
        cT = (EditText)findViewById(R.id.c_t);
        cN = (EditText)findViewById(R.id.c_n);
        dR = (EditText)findViewById(R.id.d_r);
        dS = (EditText)findViewById(R.id.d_s);
        dT = (EditText)findViewById(R.id.d_t);
        dN = (EditText)findViewById(R.id.d_n);
    }

    public void save(){
        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(rN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Data R-N", Toast.LENGTH_SHORT).show();
                        }else if(rS.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi R-S", Toast.LENGTH_SHORT).show();
                        }else if(sN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi S-N", Toast.LENGTH_SHORT).show();
                        }else if(rT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi R-T", Toast.LENGTH_SHORT).show();
                        }else if(tN.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi T-N", Toast.LENGTH_SHORT).show();
                        }else if(sT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi S-T", Toast.LENGTH_SHORT).show();
                        }else if(aR.getText().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris A", Toast.LENGTH_SHORT).show();
                        }else if(aS.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris A", Toast.LENGTH_SHORT).show();
                        }else if(aT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris A", Toast.LENGTH_SHORT).show();
                        }else if(aN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom N Baris A", Toast.LENGTH_SHORT).show();
                        }else if(bR.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris B", Toast.LENGTH_SHORT).show();
                        }else if(bS.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris B", Toast.LENGTH_SHORT).show();
                        }else if(bT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris B", Toast.LENGTH_SHORT).show();
                        }else if(bN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom N Baris B", Toast.LENGTH_SHORT).show();
                        }else if(cR.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris C", Toast.LENGTH_SHORT).show();
                        }else if(cS.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris C", Toast.LENGTH_SHORT).show();
                        }else if(cT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris C", Toast.LENGTH_SHORT).show();
                        }else if(cN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom N Baris C", Toast.LENGTH_SHORT).show();
                        }else if(dR.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom R Baris D", Toast.LENGTH_SHORT).show();
                        }else if(dS.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom S Baris D", Toast.LENGTH_SHORT).show();
                        }else if(dT.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom T Baris D", Toast.LENGTH_SHORT).show();
                        }else if(dN.getText().toString().equals("")){
                            Toast.makeText(context, "Mohon Isi Kolom N Baris D", Toast.LENGTH_SHORT).show();
                        }else {
                            garduMap.setRn(rN.getText().toString());
                            garduMap.setRs(rS.getText().toString());
                            garduMap.setSn(sN.getText().toString());
                            garduMap.setRt(rT.getText().toString());
                            garduMap.setTn(tN.getText().toString());
                            garduMap.setSt(sT.getText().toString());
                            garduMap.setAr(aR.getText().toString());
                            garduMap.setAs(aS.getText().toString());
                            garduMap.setAt(aT.getText().toString());
                            garduMap.setAn(aN.getText().toString());
                            garduMap.setBr(bR.getText().toString());
                            garduMap.setBs(bS.getText().toString());
                            garduMap.setBt(bT.getText().toString());
                            garduMap.setBn(bN.getText().toString());
                            garduMap.setCr(cR.getText().toString());
                            garduMap.setCs(cS.getText().toString());
                            garduMap.setCt(cT.getText().toString());
                            garduMap.setCn(cN.getText().toString());
                            garduMap.setDr(dR.getText().toString());
                            garduMap.setDs(dS.getText().toString());
                            garduMap.setDt(dT.getText().toString());
                            garduMap.setDn(dN.getText().toString());
                            Intent intent = new Intent("com.niscalindo.simantan.controller.UkuranLain");
                            intent.putExtra("GARDU_SESSION", (Serializable) garduMap);
                            startActivity(intent);
                        }

                    }
                }
        );

    }

    public void back(){
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent("com.niscalindo.simantan.controller.AddGardu");
                            intent.putExtra("GARDU_AND_MAP", (Serializable) garduMap);
                            startActivity(intent);
                    }


                }
        );

    }
}
