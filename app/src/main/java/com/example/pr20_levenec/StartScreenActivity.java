package com.example.pr20_levenec;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreenActivity extends AppCompatActivity {

    // Задержка 10 секунд

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(StartScreenActivity.this, MainActivity.class));
            finish();
        }, 10_000L);
    }
}