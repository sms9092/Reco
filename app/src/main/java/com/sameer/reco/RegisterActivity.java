package com.sameer.reco;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText etName = findViewById(R.id.etName);
        final EditText etUserName = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);

        final Button bRegister = findViewById(R.id.Reggister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    final String name = etName.getText().toString();
                    final String username = etUserName.getText().toString();
                    final String password = etPassword.getText().toString();



                    Call<ResponseBody> call = RetroFitClient
                            .getInstance()
                            .getApi()
                            .RegisterUser(name,username,password);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                           try {
                               String s = response.body().string();
                               System.out.println("Successful");
                               Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_LONG).show();
                           } catch (IOException e){
                               e.printStackTrace();
                           }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            System.out.println("Failed");
                            Toast.makeText(RegisterActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

            }
        });


    } //OnCreate




}//Main Activity
