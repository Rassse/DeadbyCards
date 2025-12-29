package com.example.deadbycards;

import java.io.Serializable;

public class Survivor implements Serializable {

    private final String name;
    private final String perkOne;
    private final String perkTwo;
    private final String perkThree;
    private final String perkFour;

    public Survivor(String name) {
        this.name = name;
        this.perkOne = "";
        this.perkTwo = "";
        this.perkThree = "";
        this.perkFour = "";
    }
}
