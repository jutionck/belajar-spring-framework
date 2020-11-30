package com.enigmacamp.mandiri;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //call methods on the bean
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());

        //call methods on the bean with literal values
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());

        //close teh context
        context.close();
    }
}
