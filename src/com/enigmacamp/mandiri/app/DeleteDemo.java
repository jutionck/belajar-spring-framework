package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //Get instructor by id /Primary Key
            int theId = 1;

            Instructor tempInstructor =
                    session.get(Instructor.class, theId);

            System.out.println("FOUND ID: " + tempInstructor);

            //delete the instructor
            if(tempInstructor != null) {
                System.out.println("DELETING: " + tempInstructor);
                //NOTE: ALSO delete detail object
                session.delete(tempInstructor);
            }

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
