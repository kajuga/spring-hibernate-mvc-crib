package com.fedorov.hibernate.demo.hb_eager_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_EL.class)
                .addAnnotatedClass(InstructorDetail_EL.class)
                .addAnnotatedClass(Course_EL.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();


            //get the instructor from db
            int theId = 3;
            Instructor_EL instructor = session.get(Instructor_EL.class, theId);

            System.out.println("DEMO eager or laizy!! Instructor: " + instructor);
//
//          get course for the instructon
//          WARNING!!! if i try do this after session.close(), i caught exception!!
            System.out.println("DEMO eager or laizy!! Courses: " + instructor.getCourses());

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












