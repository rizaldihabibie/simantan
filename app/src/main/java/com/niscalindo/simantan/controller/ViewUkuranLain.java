package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;

/**
 * Created by USER on 3/11/2018.
 */
public class ViewUkuranLain extends AppCompatActivity{

    private Gardu gardu;
    private Button backButton, saveButton;
    private EditText fuseAr, fuseAs, fuseAt;
    private EditText fuseBr, fuseBs, fuseBt;
    private EditText fuseCr, fuseCs, fuseCt;
    private EditText fuseDr, fuseDs, fuseDt;
    private EditText noSeri, tglPasang, tglGanti;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ukuran_lain_lain);
        context = this;
        init();
        if(getIntent().hasExtra("GARDU_DATA_SESSION")){
            gardu = (Gardu) getIntent().getSerializableExtra("GARDU_DATA_SESSION");
            fillData(gardu);
            setEnable(false);
        }
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
        saveButton.setVisibility(View.GONE);
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.ViewTeganganBeban");
                        intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                        startActivity(intent);
                    }
                }
        );
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

    public void setEnable(Boolean con){
        fuseAr.setEnabled(con);
        fuseAs.setEnabled(con);
        fuseAt.setEnabled(con);
        fuseBr.setEnabled(con);
        fuseBs.setEnabled(con);
        fuseBt.setEnabled(con);
        fuseCr.setEnabled(con);
        fuseCs.setEnabled(con);
        fuseCt.setEnabled(con);
        fuseDr.setEnabled(con);
        fuseDs.setEnabled(con);
        fuseDt.setEnabled(con);
        noSeri.setEnabled(con);
        tglGanti.setEnabled(con);
        tglPasang.setEnabled(con);
    }
}
