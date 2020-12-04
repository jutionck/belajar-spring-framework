package com.enigmacamp.mandiri.app.coursestudent;

import com.enigmacamp.mandiri.entity.*;
import com.enigmacamp.mandiri.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //create course
            Course tempCourse = new Course("PHP Fundamental");
            session.save(tempCourse);
            //create the students
            String theDateOfBirthStr = "11/11/1996";
            String theDateOfBirthStr2 = "05/05/1998";
            Date theDateOfBirth = DateUtil.parseDate(theDateOfBirthStr);
            Date theDateOfBirth2 = DateUtil.parseDate(theDateOfBirthStr2);
            Student tempStudent1 = new Student( "Ibad", "Sanjaya", "ibad@gmail.com", theDateOfBirth);
            Student tempStudent2 = new Student( "Reza", "Fajriansyah", "fajriansyah@gmail.com", theDateOfBirth2);
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            //add students to the course
            System.out.println("Saving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Save students... " + tempCourse.getStudents());
            //save the students

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();

        } catch (ParseException e) {
            e.printStackTrace();
        };
    }
}
