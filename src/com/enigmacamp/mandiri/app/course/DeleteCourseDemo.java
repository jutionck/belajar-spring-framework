package com.enigmacamp.mandiri.app.course;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

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
            int theCourse = 2;
            Course tempCourse = session.get(Course.class, theCourse);

            //delete the course
            System.out.println("Delete course: " + tempCourse.getTitle());
            session.delete(tempCourse);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();
        }
    }
}
