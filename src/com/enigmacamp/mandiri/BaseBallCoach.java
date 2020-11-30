package com.enigmacamp.mandiri;

public class BaseBallCoach implements Coach {

    //define a private field for dependency injection
    private FortuneService fortuneService;

    //overloading
    public BaseBallCoach() {}

    //define a constructor for dependency injection
    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        //dependency = helper
        return fortuneService.getFortune();
    }
}
