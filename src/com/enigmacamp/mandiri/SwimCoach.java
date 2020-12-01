package com.enigmacamp.mandiri;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;


    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
