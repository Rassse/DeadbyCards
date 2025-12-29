package com.example.deadbycards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SurvivorLoadout extends AppCompatActivity {

    private SurvivorStorage survivorStorage;

    RecyclerView recyclerView;

    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survivor_loadout);

        survivorStorage = SurvivorStorage.getInstance();

        recyclerView = findViewById(R.id.rvUserList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SurvivorLoadoutManager(getApplicationContext(), survivorStorage.getSurvivors()));



        floatingActionButton = findViewById(R.id.addLoadout);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(SurvivorLoadout.this, AddSurvivor.class);
            startActivity(intent);
        });
    }


}
