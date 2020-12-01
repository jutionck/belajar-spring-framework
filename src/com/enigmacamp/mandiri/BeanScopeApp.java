package com.enigmacamp.mandiri;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        //Check if they are the same
        boolean result = (theCoach == alphaCoach);

        //print out the results
        System.out.println("\nPointing to the same object " + result);

        System.out.println("\nMemory location from theCoach " + theCoach);
        System.out.println("\nMemory location from alphaCoach " + alphaCoach);

        //Close context
        context.close();
    }

}
