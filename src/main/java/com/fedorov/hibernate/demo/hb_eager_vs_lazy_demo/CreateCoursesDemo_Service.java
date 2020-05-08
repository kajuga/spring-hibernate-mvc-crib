package com.fedorov.hibernate.demo.hb_eager_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo_Service {

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

            //create some courses
            Course_EL tempCourse1 =  new Course_EL("Air Guitar - The ultimate Guide ");
            Course_EL tempCourse2 =  new Course_EL("Programming courses by Petr Arsentiev");

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












