package com.enigmacamp.mandiri.app.student;

import com.enigmacamp.mandiri.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {
//            int studentId = 2;
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Student myStudent = session.get(Student.class, studentId);
//            session.delete(myStudent);
//            session.getTransaction().commit();

            System.out.println("Delete student...");
            System.out.println("Delete with createQuery..");

            session = factory.getCurrentSession();
            session.beginTransaction();
            String deleteStudent = "DELETE FROM Student WHERE id = 3";
            session.createQuery(deleteStudent).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
