package com.example.food_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.food_app.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout introBtnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Mapping();
        HandleStart();
    }

    private void HandleStart() {
        introBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }

    private void Mapping() {
        introBtnStart = findViewById(R.id.intro_btn_start);
    }
}
