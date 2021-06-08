package com.example.healthary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration1 extends AppCompatActivity implements View.OnClickListener {

    private TextView backBtn;
    private Button loseWeightBtn, maintainWeightBtn, gainWeightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration1);

        backBtn = (TextView) findViewById(R.id.back_btn);
        loseWeightBtn = (Button) findViewById(R.id.lose_weight);
        maintainWeightBtn = (Button) findViewById(R.id.maintain_weight);
        gainWeightBtn = (Button) findViewById(R.id.gain_weight);

        backBtn.setOnClickListener(this);
        loseWeightBtn.setOnClickListener(this);
        maintainWeightBtn.setOnClickListener(this);
        gainWeightBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                Intent backIntent = new Intent(this, Authentication.class);
                startActivity(backIntent);
                break;
            case R.id.lose_weight:
                Intent nextActivityIntent1 = new Intent(this, Registration2.class);
                startActivity(nextActivityIntent1);
            case R.id.maintain_weight:
                Intent nextActivityIntent2 = new Intent(this, Registration2.class);
                startActivity(nextActivityIntent2);
            case R.id.gain_weight:
                Intent nextActivityIntent3 = new Intent(this, Registration2.class);
                startActivity(nextActivityIntent3);
            default:
                break;
        }
    }

}
