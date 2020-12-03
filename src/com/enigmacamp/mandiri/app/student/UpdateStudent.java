package com.enigmacamp.mandiri.app.student;

import com.enigmacamp.mandiri.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Update student...");
            myStudent.setLastName("Candra Kirana");
            session.getTransaction().commit();

            //Update with createQuery
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Update with createQuery..");
            String updateStudent = "UPDATE Student set email = 'jutionck@gmail.com' WHERE id = 1";
            session.createQuery(updateStudent).executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
