package com.example.deadbycards;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class ChooseSide extends AppCompatActivity {

    float bonus = (float) Math.random();
    int check = (int) (Math.random() * 2);
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_side);

        if (check == 1) {
            float bonusForSurvivor = 1 + bonus;
            textview = findViewById(R.id.survivorBonus);
            String twoDecimalBonusSurvivor = String.format("%.1f", bonusForSurvivor);
            textview.setText(twoDecimalBonusSurvivor + "x");
        }

        else {
            float bonusForKiller = 1 + bonus;
            textview = findViewById(R.id.killerBonus);
            String twoDecimalBonusKiller = String.format("%.1f", bonusForKiller);
            textview.setText(twoDecimalBonusKiller + "x");
        }
    }



    public void changeToSurvivor(View view) {
        Intent intent = new Intent(ChooseSide.this, SurvivorLoadout.class);
        startActivity(intent);


    }

    public void changeToKiller(View view) {
        Intent intent = new Intent(ChooseSide.this, KillerLoadout.class);
        startActivity(intent);
    }
}
