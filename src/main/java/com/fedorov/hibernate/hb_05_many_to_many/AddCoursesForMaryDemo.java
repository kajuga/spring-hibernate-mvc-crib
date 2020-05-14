package com.fedorov.hibernate.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_05.class)
                .addAnnotatedClass(InstructorDetail_05.class)
                .addAnnotatedClass(Course_05.class)
                .addAnnotatedClass(Review_05.class)
                .addAnnotatedClass(Student_05.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get the student sashok from database
            int tempId = 12;
            Student_05 student = session.get(Student_05.class, tempId);

            System.out.println("\nLoaded student: " + student);
            System.out.println("Courses: " + student.getCourses());

            //create more courses
            Course_05 course1 =  new Course_05("OTUS Java courses");
            Course_05 course2 =  new Course_05("Petr Arsentiev Java courses");
            //add student to courses

            course1.addStudent(student);
            course2.addStudent(student);

            //save courses
            session.save(course1);
            session.save(course2);

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












