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
            //crate a student object
            Student newStudent = new Student(
                    "Jution",
                    "Kirana",
                    "jution.kirana@gmail.com"
            );

            //start transaction
            session.beginTransaction();

            //save the student
            session.save(newStudent);

            //commit the transaction
            session.getTransaction().commit();
        }
    }
}
