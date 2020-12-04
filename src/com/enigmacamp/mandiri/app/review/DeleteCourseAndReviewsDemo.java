package com.enigmacamp.mandiri.app.review;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import com.enigmacamp.mandiri.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            int theIdCourse = 7;
            Course tempCourse = session.get(Course.class, theIdCourse);

            System.out.println("Delete course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            //delete
            session.delete(tempCourse);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();
        }
    }
}
