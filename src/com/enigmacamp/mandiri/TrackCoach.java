package com.enigmacamp.mandiri;

public class TrackCoach implements Coach {

    //private DI
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //bean lifecycle
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    public void doMyCleanStuffYoYo() {
        System.out.println("TrackCoach: inside method doMyCleanStuffYoYo");
    }
}
