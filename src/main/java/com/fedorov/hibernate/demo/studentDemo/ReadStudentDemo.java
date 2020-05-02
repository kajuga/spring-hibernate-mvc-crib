package com.fedorov.hibernate.demo.studentDemo;

import com.fedorov.hibernate.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object

            //create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Duffy", "Duck", "duffyduck@mail.ru");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            //Me new code

            //find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //now get  a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();


            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myLoadStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myLoadStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}







