package com.fedorov.hibernate.demo.instructorDemo;

import com.fedorov.hibernate.demo.entities.Instructor;
import com.fedorov.hibernate.demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor tempInstructor = new Instructor("Aleksandr", "Fedorov", "kajuga@mail.ru");

            //associate the objects
            InstructorDetail tempInstructorDetail = new InstructorDetail("Channel", "coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor. Also save the details object cause CascadeType.ALL
            System.out.println("Saving the instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}