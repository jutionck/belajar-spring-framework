package com.enigmacamp.mandiri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//default component is, name the class
@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Print out from default constructor: TennisCoach");
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Print out from setter: setFortuneService");
//        this.fortuneService = fortuneService;
//    }

    //costume method, ANY method
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
