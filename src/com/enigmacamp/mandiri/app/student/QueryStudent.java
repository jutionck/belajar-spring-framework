package com.enigmacamp.mandiri.app.student;

import com.enigmacamp.mandiri.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //query Student
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //Display all student
            displayStudent(theStudents);

            //display with where specific
            theStudents = session.createQuery("from Student s WHERE firstName='Jution'").getResultList();
            System.out.println("\nGet student with firstName: Jution");
            displayStudent(theStudents);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void displayStudent(List<Student> theStudents) {
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }
}
