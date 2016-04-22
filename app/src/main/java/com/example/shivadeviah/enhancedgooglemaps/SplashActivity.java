package com.example.shivadeviah.enhancedgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
