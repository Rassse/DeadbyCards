package com.example.deadbycards;

import java.util.ArrayList;

public class SurvivorStorage {
    private String name;
    public ArrayList<Survivor> survivors = new ArrayList<Survivor>();
    private static SurvivorStorage survivorStorage = null;


    public void addSurvivor(Survivor survivor) {
        if (survivors.add(survivor)) {
            System.out.println("Survivor added succesfully");
        }
    }

    public static SurvivorStorage getInstance() {
        if(survivorStorage == null) {
            survivorStorage = new SurvivorStorage();
        }
        return survivorStorage;
    }



}
