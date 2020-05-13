package com.fedorov.hibernate.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

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

            //create a course
            Course_05 course =new Course_05("Pacman - How to score One Million Points");


            System.out.println("\nSaving the course ...");
            session.save(course);
            System.out.println("Saved the course: " + course);

            //create the students

            Student_05 student1 = new Student_05("John", "Doe", "fedorov@mail.ru");
            Student_05 student2 = new Student_05("Sashok", "Fedorov", "chiasmodon@gmail.com");

            //add students to the Course
            course.addStudent(student1);
            course.addStudent(student2);

            //save the students
            System.out.println("\nSaving students");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: ... " + course.getStudents());

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












