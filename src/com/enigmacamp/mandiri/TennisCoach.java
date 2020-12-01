package com.enigmacamp.mandiri;

import org.springframework.stereotype.Component;

//default component is, name the class
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
