package com.fedorov.hibernate.demo.instructorDemo;

import com.fedorov.hibernate.demo.entities.one_to_one_uni.Instructor;
import com.fedorov.hibernate.demo.entities.one_to_one_uni.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

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
            //start a transaction
            session.beginTransaction();

            //get instructor by primary key/id
            int tempId = 1;
            Instructor tempInstructor = session.get(Instructor.class, tempId);

            //delete the instructors
            session.delete(tempInstructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}