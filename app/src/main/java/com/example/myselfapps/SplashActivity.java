package com.example.myselfapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myselfapps.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    private int waktu_loading = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(home);
                finish();

            }
        }, waktu_loading);
    }
}