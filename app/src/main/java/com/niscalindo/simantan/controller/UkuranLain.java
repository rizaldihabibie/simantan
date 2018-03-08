package com.niscalindo.simantan.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;

/**
 * Created by USER on 3/5/2018.
 */
public class UkuranLain extends AppCompatActivity {

    private Gardu garduMap;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ukuran_lain_lain);
//        garduDao = new GarduDaoImpl();
//        context = this;
        init();

        if(getIntent().hasExtra("GARDU_SESSION")){
            garduMap = (Gardu) getIntent().getSerializableExtra("GARDU_SESSION");
//            fillData(garduMap);
        }
        back();
    }

    public void init(){
        backButton = (Button)findViewById(R.id.backButton);
    }
    public void back(){
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.niscalindo.simantan.controller.TeganganBeban");
                        intent.putExtra("GARDU_TEGANGAN", (Serializable) garduMap);
                        startActivity(intent);
                    }


                }
        );

    }
}
