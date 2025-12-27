package com.example.deadbycards;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;


public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_DeadByCards);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Intent intent = new Intent(Intro.this, LoadingScreenActivity.class);
                startActivity(intent);
            }
        }).start();

    }




}

