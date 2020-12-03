package com.enigmacamp.mandiri.app.course;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {

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

            //get the instructor from db
            int theIdInstructor = 1;
            Instructor tempInstructor = session.get(Instructor.class, theIdInstructor);

            //Validation
            if(tempInstructor != null) {
                //print out List Course with instructor
                System.out.println("\nInstructor: " + tempInstructor);
                System.out.println("\nCourse: " + tempInstructor.getCourses());

                //commit the transaction
                session.getTransaction().commit();
                System.out.println("Done!");
            }
            System.out.println("Not Found Instructor: " + theIdInstructor);
            session.close();
        }
    }
}
