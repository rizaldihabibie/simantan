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

/**
 * Created by USER on 3/11/2018.
 */
public class ViewTeganganBeban extends AppCompatActivity {
    private Context context;
    private Gardu gardu;
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
        context = this;
        init();
        if(getIntent().hasExtra("GARDU_DATA_SESSION")){
            gardu = (Gardu) getIntent().getSerializableExtra("GARDU_DATA_SESSION");
            fillData(gardu);
            setEnable(false);
        }
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
        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.ViewUkuranLain");
                        intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                        startActivity(intent);
                    }
                }
        );
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.ViewGardu");
                        intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                        startActivity(intent);
                    }
                }
        );
    }
    public void fillData(Gardu gardu){
        Toast.makeText(context, "jajal ah : "+gardu.getRn() ,
                Toast.LENGTH_SHORT).show();
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
    public void setEnable(boolean con){
        rN.setEnabled(con);
        rS.setEnabled(con);
        sN.setEnabled(con);
        rT.setEnabled(con);
        tN.setEnabled(con);
        sT.setEnabled(con);
        aR.setEnabled(con);
        aS.setEnabled(con);
        aT.setEnabled(con);
        aN.setEnabled(con);
        bR.setEnabled(con);
        bS.setEnabled(con);
        bT.setEnabled(con);
        bN.setEnabled(con);
        cR.setEnabled(con);
        cS.setEnabled(con);
        cT.setEnabled(con);
        cN.setEnabled(con);
        dR.setEnabled(con);
        dS.setEnabled(con);
        dT.setEnabled(con);
        dN.setEnabled(con);
    }

}
