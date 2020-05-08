package com.fedorov.hibernate.demo.entities.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            //create some courses
            Course tempCourse1 =  new Course("Air Guitar - The ultimate Guide ");
            Course tempCourse2 =  new Course("Programming courses by Petr Arsentiev");

            //add courses to instructor
            instructor.add(tempCourse1);
            instructor.add(tempCourse2);

            //save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);

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












