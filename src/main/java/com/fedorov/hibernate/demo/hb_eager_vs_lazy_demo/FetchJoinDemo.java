package com.fedorov.hibernate.demo.hb_eager_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

            //option 2^ Hibernate querry with HQL


            //get the instructor from db
            int theId = 3;
            Query<Instructor_EL> query = session.createQuery("select i from Instructor_EL i "
                    + "JOIN FETCH i.courses "
                    + "where i.id=:theInstructorId", Instructor_EL.class);

            query.setParameter("theInstructorId", theId);
            //execute cuery and get instructro
            Instructor_EL tempInstructor = query.getSingleResult();

            System.out.println("Fedorov2code: Instructor: " + tempInstructor);


            //commit transaction
            session.getTransaction().commit();

            //close the session
            session.close();
            System.out.println("Fedorov2code: The session now is closed!\n");

//          WARNING!!! if i try do this after session.close(), i caught exception!!
            System.out.println("Fedorov2code: Courses: " + tempInstructor.getCourses());


            System.out.println("Done!");
        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }
}












