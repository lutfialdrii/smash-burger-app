package com.example.projectappmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class IntroAppsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_apps);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(IntroAppsActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}