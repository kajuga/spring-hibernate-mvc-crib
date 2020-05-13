package com.fedorov.hibernate.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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
            session.beginTransaction();

            //create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("John2", "Rambo2", "msg2unk2@gmail.com");


            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

//            another way to insert my Stunent in table:


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }


    }
}







