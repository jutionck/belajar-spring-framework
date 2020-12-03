package com.enigmacamp.mandiri.app.eagerlazy;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            //Hibernate query with HQL
            //get the instructor from db
            int theIdInstructor = 2;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + " JOIN FETCH i.courses "
                            + " where i.id=:theIdInstructor", Instructor.class);

            query.setParameter("theIdInstructor", theIdInstructor);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("\nInstructor: " + tempInstructor);
            System.out.println("\nCourse: " + tempInstructor.getCourses());

            session.getTransaction().commit();
            session.close();
        }
    }
}
