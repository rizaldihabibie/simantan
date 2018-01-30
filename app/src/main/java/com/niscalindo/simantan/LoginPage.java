package com.niscalindo.simantan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by USER on 1/28/2018.
 */
public class LoginPage extends AppCompatActivity{
    private static EditText username;
    private static EditText password;
    private static Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginAction();
    }

    public void loginAction(){
        username = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.email_sign_in_button);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent("com.niscalindo.simantan.MainMenu");
                        startActivity(intent);
                    }
                }
        );
    }
}
