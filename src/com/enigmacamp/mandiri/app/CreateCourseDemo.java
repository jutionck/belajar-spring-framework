package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //get the instructor from db
            int theIdInstructor = 2;
            Instructor tempInstructor = session.get(Instructor.class, theIdInstructor);

            //create some course
            String[] tempCourse = {
                    "Java Fundamental",
                    "Node Js",
                    "Java Spring",
                    "Kotlin Fundamental",
                    "Kotlin Android",
                    "Docker"
            };

            for (String newCourse: tempCourse) {
                Course saveCourse = new Course(newCourse);

                //add course to instructor
                tempInstructor.add(saveCourse);

                //save the courses
                session.save(saveCourse);
            }

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();
        }
    }
}
