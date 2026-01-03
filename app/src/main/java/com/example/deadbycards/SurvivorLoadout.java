package com.example.deadbycards;

import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SurvivorLoadout extends AppCompatActivity {
    ConnectToDatabase db;
    ArrayList<String> names, images, perkOnes, perkTwos, perkThrees, perkFours;
    ArrayList<Boolean> checkLevels;

    private SurvivorStorage survivorStorage;

    RecyclerView recyclerView;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survivor_loadout);
        db = new ConnectToDatabase(this);
        names = new ArrayList<>();
        images = new ArrayList<>();
        perkOnes = new ArrayList<>();
        perkTwos = new ArrayList<>();
        perkThrees = new ArrayList<>();
        perkFours = new ArrayList<>();
        checkLevels = new ArrayList<>();

        Cursor cursor = db.fetchDatabase();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Error happened", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                names.add(cursor.getString(1));
                images.add(cursor.getString(2));
                perkOnes.add(cursor.getString(3));
                perkTwos.add(cursor.getString(4));
                perkThrees.add(cursor.getString(5));
                perkFours.add(cursor.getString(6));
                int check = cursor.getInt(7);
                checkLevels.add(check == 1);
            }
        }

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
