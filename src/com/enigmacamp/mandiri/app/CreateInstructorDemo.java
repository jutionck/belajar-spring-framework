package com.enigmacamp.mandiri.app;

import com.enigmacamp.mandiri.entity.Course;
import com.enigmacamp.mandiri.entity.Instructor;
import com.enigmacamp.mandiri.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (factory) {

            Session session = factory.getCurrentSession();

            //Create object
            Instructor tempInstructor =
                    new Instructor(
                            "Yussin",
                            "R. Hidayat",
                            "yussin.hidayat@enigmacamp.com"
                    );

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://youtube.com/channel/yussinhidayat",
                            "Coding"
                    );

            //associate the object
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();

            //save the instructor
            //NOTE:this will ALSO save the detail, because CasecadeType.ALl
            System.out.println("Saving instructor:" + tempInstructor);
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session.close();
        }
    }
}
