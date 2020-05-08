package com.fedorov.hibernate.demo.entities.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

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
            //get the instructor from db
            int theId = 1;
            Instructor_03 instructor = session.get(Instructor_03.class, theId);

            System.out.println("Instructor: " + instructor);
            //get course for the instructor
            System.out.println("Courses: " + instructor.getCourses());




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












