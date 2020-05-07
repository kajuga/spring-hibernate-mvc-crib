package com.fedorov.hibernate.demo.entities.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_02.class)
                .addAnnotatedClass(InstructorDetail_02.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();


            //get the instructor detail object
            int theId = 2;
            InstructorDetail_02 instructorDetail = session.get(InstructorDetail_02.class, theId);

            //print the instructor detail
            System.out.println("tempInstructionDetail: " + instructorDetail);

            //print the assosiated instructor
            System.out.println("the assotiated instructor: " + instructorDetail.getInstructor02());


            //commit transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}