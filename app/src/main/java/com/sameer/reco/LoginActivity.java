package com.sameer.reco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if(username.isEmpty()){
            etUserName.setError("Username is required");
            etUserName.requestFocus();
        }

        if(password.isEmpty()){
            etPassword.setError("Password is required");
            etPassword.requestFocus();
        }
        Call<User> call = RetroFitClient
                .getInstance()
                .getApi()
                .loginUser(username,password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {



                 if(response.body().getResponse().equals("okay"))
                 {
                     System.out.println("Successful");
                     MainActivity.prefconfig.writeLoginStatus(true);
                     MainActivity.prefconfig.writeName(response.body().getName());
                     Intent UserIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                     LoginActivity.this.startActivity(UserIntent);

                 }
                 else if (response.body().getResponse().equals("failed"))
                 {
                     System.out.println("failed");


                 }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                MainActivity.prefconfig.displayToast("Login Failed.. PLease try again");
            }
        });
        etUserName.setText("");
        etPassword.setText("");
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
