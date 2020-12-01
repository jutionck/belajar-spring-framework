package com.enigmacamp.mandiri;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        //Print out lifecycle
        System.out.println(theCoach.getDailyWorkout());

        //Close context
        context.close();
    }

}
