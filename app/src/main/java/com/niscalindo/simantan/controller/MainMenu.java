package com.niscalindo.simantan.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.niscalindo.simantan.R;

/**
 * Created by USER on 1/29/2018.
 */
public class MainMenu extends AppCompatActivity {
    private static Button buttonSimanis;
    private static Button buttonSimadu;
    private static Button buttonGps;
    private int countKeyPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);
        countKeyPressed = 0;
        buttonSimadu = (Button)findViewById(R.id.simadu_button);
        buttonSimadu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        cre = loginDao.login(username.getText().toString(),password.getText().toString(),context);
//                        if(!cre.getUsername().equals("kosong")){
//                            Intent intent = new Intent("com.niscalindo.simantan.controller.ContentGardu");
                            Intent intent = new Intent("com.niscalindo.simantan.controller.MainActivity");
                            startActivity(intent);
//                        }
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        countKeyPressed++;
        if(countKeyPressed==2){
            Intent intent = new Intent(this,LoginPage.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Press Back Again To Logout..",Toast.LENGTH_SHORT).show();
        }
    }
}
