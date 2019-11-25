package com.sameer.reco;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText etName = findViewById(R.id.etName);
        final EditText etUserName = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etMobileNumber = findViewById(R.id.etMobileNumber);
                        mDisplayDate = findViewById(R.id.etDate);
        final Spinner etBloodGroup = findViewById(R.id.spinner);

        final Button bRegister = findViewById(R.id.Register);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year =cal.get(Calendar.YEAR);
                int month =cal.get(Calendar.MONTH);
                int day =cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                       dialog.show();

            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String Date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(Date);
                System.out.println(Date);
            }
        };

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    final String name = etName.getText().toString();
                    final String username = etUserName.getText().toString();
                    final String password = etPassword.getText().toString();
                    final String mobile = etMobileNumber.getText().toString();
                    final String blood = etBloodGroup.getSelectedItem().toString();
                    final String dob = mDisplayDate.getText().toString();


                    Call<User> call = RetroFitClient
                            .getInstance()
                            .getApi()
                            .RegisterUser(name,username,password,mobile,blood,dob);

                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {

                               Intent LoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                               RegisterActivity.this.startActivity(LoginIntent);



                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            System.out.println("Failed");
                            Toast.makeText(RegisterActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

            }
        });


    } //OnCreate




}//Main Activity
