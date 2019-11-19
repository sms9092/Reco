package com.sameer.reco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    public static Preference prefconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefconfig = new Preference(this);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (prefconfig.readLoginStatus())
                {
                    Intent WelcomeIntent = new Intent(MainActivity.this, UserAreaActivity.class);
                    MainActivity.this.startActivity(WelcomeIntent);
                }
                else
                {
                    Intent LoginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    MainActivity.this.startActivity(LoginIntent);
                }


            }
        }, 1000);






    }
}
