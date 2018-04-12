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
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by USER on 3/3/2018.
 */
public class TeganganBeban extends AppCompatActivity {
    private Context context;
    private Gardu garduMap;
    private EditText rN, rS, sN,rT,tN,sT;
    private EditText aR, aS, aT, aN;
    private EditText bR,bS, bT, bN;
    private EditText cR,cS, cT, cN;
    private EditText dR,dS, dT, dN;
    private EditText totalR,totalS, totalT, totalN;
    private Button nextButton, backButton;
    private Double kolomR, kolomS,kolomT,kolomN;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tegangan_beban);
        context = this;
        df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
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
        aR.setText("0.0");
        aS.setText("0.0");
        aT.setText("0.0");
        aN.setText("0.0");
        bR.setText("0.0");
        bS.setText("0.0");
        bT.setText("0.0");
        bN.setText("0.0");
        cR.setText("0.0");
        cS.setText("0.0");
        cT.setText("0.0");
        cN.setText("0.0");
        dR.setText("0.0");
        dS.setText("0.0");
        dT.setText("0.0");
        dN.setText("0.0");
        totalR = (EditText)findViewById(R.id.total_r);
        totalS = (EditText)findViewById(R.id.total_s);
        totalT = (EditText)findViewById(R.id.total_t);
        totalN = (EditText)findViewById(R.id.total_n);
        totalR.setEnabled(false);
        totalN.setEnabled(false);
        totalS.setEnabled(false);
        totalT.setEnabled(false);
        aR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(aR.getText().toString())){
                        onChangeListener(0);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        bR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(bR.getText().toString())){
                        onChangeListener(0);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(cR.getText().toString())){
                        onChangeListener(0);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(dR.getText().toString())){
                        onChangeListener(0);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        aS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(aS.getText().toString())){
                        onChangeListener(1);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(bS.getText().toString())){
                        onChangeListener(1);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(cS.getText().toString())){
                        onChangeListener(1);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(dS.getText().toString())){
                        onChangeListener(1);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        aT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(aT.getText().toString())){
                        onChangeListener(2);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(bT.getText().toString())){
                        onChangeListener(2);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(cT.getText().toString())){
                        onChangeListener(2);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(dT.getText().toString())){
                        onChangeListener(2);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        aN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(aN.getText().toString())){
                        onChangeListener(3);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(bN.getText().toString())){
                        onChangeListener(3);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(cN.getText().toString())){
                        onChangeListener(3);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(checkNumber(dN.getText().toString())){
                        onChangeListener(3);
                    }else{
                        Toast.makeText(context, "Not A Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
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
    public void onChangeListener(int column){
        try {
            switch (column) {
                case 0:
                    kolomR = (Double.valueOf(aR.getText().toString())) + (Double.valueOf(bR.getText().toString())) + (Double.valueOf(cR.getText().toString())) + (Double.valueOf(dR.getText().toString()));

                    totalR.setText("" + df.format(kolomR));
                    break;
                case 1:
                    kolomS = (Double.valueOf(aS.getText().toString())) + (Double.valueOf(bS.getText().toString())) + (Double.valueOf(cS.getText().toString())) + (Double.valueOf(dS.getText().toString()));
                    totalS.setText("" + df.format(kolomS));
                    break;
                case 2:
                    kolomT = (Double.valueOf(aT.getText().toString())) + (Double.valueOf(bT.getText().toString())) + (Double.valueOf(cT.getText().toString())) + (Double.valueOf(dT.getText().toString()));
                    totalT.setText("" + df.format(kolomT));
                    break;
                case 3:
                    kolomN = (Double.valueOf(aN.getText().toString())) + (Double.valueOf(bN.getText().toString())) + (Double.valueOf(cN.getText().toString())) + (Double.valueOf(dN.getText().toString()));
                    totalN.setText("" + df.format(kolomN));
                    break;
            }
        }catch (NumberFormatException e){
            Toast.makeText(context, "Error Number Format !", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkNumber(String input){
        return input.matches("\\d*\\.?\\d+");
    }


}
