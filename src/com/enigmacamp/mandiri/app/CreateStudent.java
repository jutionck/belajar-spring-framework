package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Student;
import com.enigmacamp.mandiri.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {

            //create a new student object
            System.out.println("Creating a new student object...");

            String theDateOfBirthStr = "03/07/1995";
            Date theDateOfBirth = DateUtil.parseDate(theDateOfBirthStr);

            Student newStudent = new Student(
                    "Destry",
                    "Bedul",
                    "destry.avisa@gmail.com",
                    theDateOfBirth
            );

            //start transaction
            session.beginTransaction();

            //save the student
            System.out.println("Saving the student....");
            session.save(newStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
