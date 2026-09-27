package com.example.pr20_levenec;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreenActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 10_000L;
    private Handler handler;
    private Runnable runnable;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Полноэкранный режим
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_screen);

        // Запуск таймера для перехода на MainActivity
        handler = new Handler(Looper.getMainLooper());
        runnable = () -> {
            Intent intent = new Intent(StartScreenActivity.this, MainActivity.class);
            StartScreenActivity.this.startActivity(intent);
            StartScreenActivity.this.finish();
        };

        handler.postDelayed(runnable, SPLASH_DELAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}