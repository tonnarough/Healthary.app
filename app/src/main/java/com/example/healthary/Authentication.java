package com.example.healthary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Authentication extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText ETEmail, ETPassword;
    private TextView registrationBtn, signedInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_authentication);

        mAuth = FirebaseAuth.getInstance();
        ETEmail = (EditText) findViewById(R.id.email_et);
        ETPassword = (EditText) findViewById(R.id.password_et);
        registrationBtn = (TextView) findViewById(R.id.register);
        signedInBtn = (TextView) findViewById(R.id.sign_in_btn);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //User is signed_in

                }else{
                    //User is signed_out

                }
            }
        };

        registrationBtn.setOnClickListener(this);
        signedInBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.register:
                Intent intent = new Intent(this, Registration1.class);
                startActivity(intent);
                break;
            case R.id.sign_in_btn:
                break;
            default:
                break;
        }

    }

    public void signedIn (String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    Toast.makeText(Authentication.this, "Авторизация прошла успешно", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Authentication.this, "Авторизация не выполнилась", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registration (String email,String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    Toast.makeText(Authentication.this, "Авторизация прошла успешно", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Authentication.this, "Авторизация не выполнилась", Toast.LENGTH_SHORT).show();
            }
        });
    }
}