package com.niscalindo.simantan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        buttonSimadu = (Button)findViewById(R.id.simadu_button);
        buttonSimadu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        cre = loginDao.login(username.getText().toString(),password.getText().toString(),context);
//                        if(!cre.getUsername().equals("kosong")){
                            Intent intent = new Intent("com.niscalindo.simantan.AddGardu");
                            startActivity(intent);
//                        }
                    }
                }
        );
    }

}
