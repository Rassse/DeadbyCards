package com.example.deadbycards;

import android.content.Context;

import java.io.Serializable;

public class Survivor implements Serializable {
    private final String image;

    private final String name;
    private final String perkOne;
    private final String perkTwo;
    private final String perkThree;
    private final String perkFour;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
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

    public int getImageId(Context context) {
        return context.getResources().getIdentifier(
                image,
                "drawable",
                context.getPackageName()
        );
    }

    public Survivor(String name) {
        this.name = name;
        this.image = "dwight";
        this.perkOne = "";
        this.perkTwo = "";
        this.perkThree = "";
        this.perkFour = "";
    }




}
