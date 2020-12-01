package com.enigmacamp.mandiri;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    //create an array of string
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    //create a random generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {

        //pick a random number
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];

        return theFortune;
    }
}
