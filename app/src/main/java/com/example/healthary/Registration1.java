package com.example.healthary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration1);

        TextView backBtn = (TextView) findViewById(R.id.back_btn);
        TextView loseWeightBtn = (TextView) findViewById(R.id.lose_weight);

        backBtn.setOnClickListener(this);
        loseWeightBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                Intent backIntent = new Intent(this, Authentication.class);
                startActivity(backIntent);
                break;
            case R.id.lose_weight:
                Intent nextActivityIntent = new Intent(this, Registration2.class);
                startActivity(nextActivityIntent);
            default:
                break;
        }
    }

}
