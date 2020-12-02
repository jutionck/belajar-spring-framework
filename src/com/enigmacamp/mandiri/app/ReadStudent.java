package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Student;
import com.enigmacamp.mandiri.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class ReadStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            //create a student object
            System.out.println("Creating a new student object...");

            String theDateOfBirthStr = "05/02/1998";
            Date theDateOfBirth = DateUtil.parseDate(theDateOfBirthStr);

            Student newStudent = new Student(
                    "Dinda",
                    "Aditiya",
                    "dinda.aditiya@gmail.com",
                    theDateOfBirth
            );

            //start transaction
            session.beginTransaction();

            //save the student
            System.out.println("Saving the student....");
            session.save(newStudent);

            //commit the transaction
            session.getTransaction().commit();

            //Read
            System.out.println("Get Student by id: " + newStudent.getId());

            //Get a new session
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting student with ID: " + newStudent.getId());

            Student getStudent = session.get(Student.class, newStudent.getId());
            System.out.println("Get Complete: " + getStudent);

            System.out.println("Done!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
