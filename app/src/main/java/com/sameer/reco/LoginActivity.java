package com.sameer.reco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName;
    private EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         etUserName = findViewById(R.id.etUsername);
         etPassword = findViewById(R.id.etPassword);

       findViewById(R.id.Login).setOnClickListener(this);
       findViewById(R.id.tvRegisterHere).setOnClickListener(this);
    }




    private void registerActivity(){
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(registerIntent);


    }


    private void userLogin(){
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(username.isEmpty()){
            etUserName.setError("Username is required");
            etUserName.requestFocus();

        }

        if(password.isEmpty()){
            etPassword.setError("Password is required");
            etPassword.requestFocus();

        }

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.Login:
                userLogin();
                break;

            case R.id.tvRegisterHere:
                registerActivity();
                break;
        }
    }

}
