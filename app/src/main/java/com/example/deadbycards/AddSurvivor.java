package com.example.deadbycards;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class AddSurvivor extends AppCompatActivity {
    ConnectToDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_survivor);

        db = new ConnectToDatabase(this);

        Survivor dwight = Survivor.createDwight();
        Survivor kate = Survivor.createKate();
        Survivor feng = Survivor.createFeng();
        Survivor michonne = Survivor.createMichonne();

        ChipGroup chipGroupDwight = findViewById(R.id.cgDwight);
        ChipGroup chipGroupFeng = findViewById(R.id.cgFeng);
        ChipGroup chipGroupKate = findViewById(R.id.cgKate);
        ChipGroup chipGroupMichonne = findViewById(R.id.cgMichonne);

        addImage(R.id.imageDwight, dwight);
        addImage(R.id.imageFeng, feng);
        addImage(R.id.imageKate, kate);
        addImage(R.id.imageMichonne, michonne);

        addPerksToChips(dwight, chipGroupDwight);
        addPerksToChips(feng, chipGroupFeng);
        addPerksToChips(kate, chipGroupKate);
        addPerksToChips(michonne, chipGroupMichonne);

        addSurvivors(R.id.buttonDwight, dwight);
        addSurvivors(R.id.buttonFeng, feng);
        addSurvivors(R.id.buttonKate, kate);
        addSurvivors(R.id.buttonMichonne, michonne);

    }

    private void addSurvivors(int id, final Survivor survivor) {
        Button button = findViewById(id);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.addSurvivor(survivor.getName(), survivor.getImage(), survivor.getPerkOne(), survivor.getPerkTwo(), survivor.getPerkThree(), survivor.getPerkFour(), survivor.getCheck());
                }
            });
        }

    }


    private void addImage(int name, Survivor survivor) {
        ImageView imageView = findViewById(name);
        if (imageView != null) {
            int id = survivor.getImageId(this);
            if (id != 0) {
                imageView.setImageResource(id);
            }
        }
    }
    private void addPerksToChips(Survivor survivor, ChipGroup chipGroup) {
        for (String perk : survivor.getPerks()) {
            Chip chip = new Chip(this);
            chip.setText(perk);
            chip.setCheckable(false);
            chipGroup.addView(chip);
        }
    }
}