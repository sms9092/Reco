package com.sameer.reco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


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


    private void userLogin() {
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();


        String url = "http://134.209.144.24/api/";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("class", "Patient");
        params.put("action", "login");
        params.put("username", username);
        params.put("password", password);
        client.get(url, params, new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject responseBody) {

             /*  String str = new String(responseBody);
               System.out.println( "Results from http" + str);
               MainActivity.prefconfig.writeProfile(responseBody);
               MainActivity.prefconfig.writeLoginStatus(true);


              */
                Intent UserIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                LoginActivity.this.startActivity(UserIntent);


                Gson gson = new Gson();
                String json = gson.toJson(responseBody);
                System.out.println("Debug this"+json);
               Response response = gson.fromJson(json,Response.class);
                System.out.println(response.toString());


            }

            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject e)  {
                // Handle the failure and alert the user to retry
                Log.e("ERROR", e.toString());
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
