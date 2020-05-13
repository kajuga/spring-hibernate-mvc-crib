package com.fedorov.hibernate.hb_04_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_04.class)
                .addAnnotatedClass(InstructorDetail_04.class)
                .addAnnotatedClass(Course_04.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get thee course
            int tempId = 3;
            Course_04 tempCourse = session.get(Course_04.class, tempId);

            //print the course
            System.out.println("Deleting the course ... ");
            System.out.println(tempCourse);

            //print the course reviews
            System.out.println(tempCourse.getRewiews());

            // delete the course
            session.delete(tempCourse);

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












