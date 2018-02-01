package com.niscalindo.simantan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.niscalindo.simantan.database.dao.LoginDao;
import com.niscalindo.simantan.database.dao.dao.impl.LoginDaoImpl;
import com.niscalindo.simantan.database.model.Credential;

/**
 * Created by USER on 1/28/2018.
 */
public class LoginPage extends AppCompatActivity{
    private static EditText username;
    private static EditText password;
    private static Button loginButton;
    private LoginDao loginDao;
    private Credential cre;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDao = new LoginDaoImpl();
        loginAction();
        context = this;
    }

    public void loginAction(){
        username = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.email_sign_in_button);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       cre = loginDao.login(username.getText().toString(),password.getText().toString(),context);
                        if(!cre.getUsername().equals("kosong")){
                            Intent intent = new Intent("com.niscalindo.simantan.controller.MainMenu");
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
