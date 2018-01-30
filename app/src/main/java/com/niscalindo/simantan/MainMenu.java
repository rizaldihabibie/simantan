package com.niscalindo.simantan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by USER on 1/29/2018.
 */
public class MainMenu extends AppCompatActivity {
    private static Button buttonSimanis;
    private static Button buttonSimadu;
    private static Button buttonGps;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);
    }
}
