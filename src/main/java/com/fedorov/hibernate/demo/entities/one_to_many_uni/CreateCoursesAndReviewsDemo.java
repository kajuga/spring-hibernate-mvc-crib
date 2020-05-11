package com.fedorov.hibernate.demo.entities.one_to_many_uni;

import com.fedorov.hibernate.demo.entities.one_to_many.Course;
import com.fedorov.hibernate.demo.entities.one_to_many.InstructorDetail_03;
import com.fedorov.hibernate.demo.entities.one_to_many.Instructor_03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

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

            //create a course
            Course_04 course =new Course_04("Pacman - How to score One Million Points");
            //add some reviews
            course.addReview(new Review("Great Course .. Loved it!"));
            course.addReview(new Review("Cool job ... Nice course!"));
            course.addReview(new Review("Well done, i winish it!"));

            //save the course ... and leverage the cascade all...
            System.out.println("saving the course");
            System.out.println(course);
            System.out.println(course.getRewiews());
            session.save(course);

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












