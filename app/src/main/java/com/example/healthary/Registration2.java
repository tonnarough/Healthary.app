package com.example.healthary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView backBtn;
    private EditText ETEmail, ETPassword, ETName, ETAge, ETWeight, ETHeight;
    private Spinner genderSpinner, dailyActivitySpinner;
    private Button registrationBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration2);

        mAuth = FirebaseAuth.getInstance();

        ETEmail = (EditText) findViewById(R.id.email_et);
        ETPassword = (EditText) findViewById(R.id.password_et);
        backBtn = (TextView) findViewById(R.id.back_btn);
        registrationBtn = (Button) findViewById(R.id.registrationBtn);
        genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        dailyActivitySpinner = (Spinner) findViewById(R.id.daily_activity_spinner);

        backBtn.setOnClickListener(this);
        registrationBtn.setOnClickListener(this);

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);
        genderSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> dailyActivityAdapter = ArrayAdapter.createFromResource(this,
                R.array.daily_activity, android.R.layout.simple_spinner_item);
        dailyActivityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dailyActivitySpinner.setAdapter(dailyActivityAdapter);
        dailyActivitySpinner.setOnItemSelectedListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                Intent backIntent = new Intent(this, Registration1.class);
                startActivity(backIntent);
                break;
            case R.id.registrationBtn:
                if (ETEmail.getText().length() == 0) {
                    Toast.makeText(Registration2.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                } else if (ETPassword.getText().length() == 0) {
                    Toast.makeText(Registration2.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                } else {
                    registration(ETEmail.getText().toString(), ETPassword.getText().toString());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intentRegistration = new Intent(Registration2.this, DiaryPage.class);
                    startActivity(intentRegistration);
                } else {
                    Toast.makeText(Registration2.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}