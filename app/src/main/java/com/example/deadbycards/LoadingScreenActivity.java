package com.example.deadbycards;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class LoadingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        ConstraintLayout constraintLayout = findViewById(R.id.clStart);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1500);
        animationDrawable.setExitFadeDuration(3200);
        animationDrawable.start();

        TextView proceedText = findViewById(R.id.proceedView);
        android.animation.ObjectAnimator proceedAnimator = android.animation.ObjectAnimator.ofFloat(proceedText, "alpha", 1.0f, 0.5f);
        proceedAnimator.setDuration(1000);
        proceedAnimator.setRepeatCount(android.animation.ObjectAnimator.INFINITE);
        proceedAnimator.setRepeatMode(android.animation.ObjectAnimator.REVERSE);
        proceedAnimator.start();

        TextView deathText = findViewById(R.id.deathView);
        android.animation.ObjectAnimator deathAnimator = android.animation.ObjectAnimator.ofFloat(deathText, "alpha", 1.0f, 0.3f);
        deathAnimator.setDuration(2000);
        deathAnimator.setRepeatCount(android.animation.ObjectAnimator.INFINITE);
        deathAnimator.setRepeatMode(android.animation.ObjectAnimator.REVERSE);
        deathAnimator.start();
    }


    public void changeScreen(View view) {
        Intent intent = new Intent(LoadingScreenActivity.this, MainPage.class);
        startActivity(intent);
    }
}
