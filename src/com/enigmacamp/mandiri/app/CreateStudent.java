package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            //create a student object
            System.out.println("Creating a new student object...");
            Student newStudent = new Student(
                    "Destry",
                    "Avisa",
                    "destry.avisa@gmail.com"
            );

            //start transaction
            session.beginTransaction();

            //save the student
            System.out.println("Saving the student....");
            session.save(newStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
