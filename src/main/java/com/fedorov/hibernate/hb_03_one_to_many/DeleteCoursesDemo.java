package com.fedorov.hibernate.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_03.class)
                .addAnnotatedClass(InstructorDetail_03.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get a course
            int tempId = 1;
            Course deleteCourse = session.get(Course.class, tempId);

            //delete course
            session.delete(deleteCourse);

             //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }
}












