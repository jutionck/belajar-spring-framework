package com.enigmacamp.mandiri.app.review;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import com.enigmacamp.mandiri.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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

            //create course
            Course tempCourse = new Course("Python Fundamental");

            //add some reviews
            String[] tempReviews = {
                    "Great course...loved it!",
                    "Cool course, job well done",
            };

            //save the reviews
            System.out.println("Saving the course...");
            for (String newReviews: tempReviews) {
                tempCourse.addReview(new Review(newReviews));
                System.out.println(tempCourse.getReviews());
                session.save(tempCourse);
            }

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();
        }
    }
}
