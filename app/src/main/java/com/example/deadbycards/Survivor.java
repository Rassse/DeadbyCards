package com.example.deadbycards;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Survivor implements Serializable {
    private final String image;
    private final String name;
    private final String perkOne;
    private final String perkTwo;
    private final String perkThree;
    private final String perkFour;
    private final boolean check;
    public ArrayList<Survivor> perks = new ArrayList<Survivor>();

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public boolean getCheck() {
        return check;
    }
    public String getPerkOne() {
        return perkOne;
    }

    public String getPerkTwo() {
        return perkTwo;
    }

    public String getPerkThree() {
        return perkThree;
    }

    public String getPerkFour() {
        return perkFour;
    }

    public List<String> getPerks() {
        List<String> perks = new ArrayList<>();
        if (!perkOne.isEmpty()) {
            perks.add(perkOne);
        }
        if (!perkTwo.isEmpty()) {
            perks.add(perkTwo);
        }
        if (!perkThree.isEmpty()) {
            perks.add(perkThree);
        }
        if (!perkFour.isEmpty()) {
            perks.add(perkFour);
        }
        return perks;
    }
    @SuppressLint("DiscouragedApi")
    public int getImageId(Context context) {
        return context.getResources().getIdentifier(
                image,
                "drawable",
                context.getPackageName()
        );
    }


    public Survivor(String name, String image, String p1, String p2, String p3, String p4, boolean check) {
        this.name = name;
        this.image = image;
        this.perkOne = p1;
        this.perkTwo = p2;
        this.perkThree = p3;
        this.perkFour = p4;
        this.check = check;
    }

    public static Survivor createDwight() {
        return new Survivor("Dwight Fairfield",
        "dwight",
        "Prove thyself",
                "Leader",
                "Bond",
                "",
                false
        );
    }

    public static Survivor createKate() {
        return new Survivor(
                "Kate Denson",
                "kate",
                "Windows of Opportunity",
                "Dance With Me",
                "Boil Over",
                "",
                false
        );
    }

    public static Survivor createFeng() {
        return new Survivor(
                "Feng Min",
                "feng",
                "Lithe",
                "Technician",
                "Alert",
                "",
                false
        );

    }
    public static Survivor createMichonne() {
        return new Survivor(
                "Michonne Grimes",
                "michonne",
                "Conviction",
                "Last stand",
                "Come and get me",
                "",
                false
        );
    }



}
