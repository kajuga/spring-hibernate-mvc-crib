package com.fedorov.hibernate.demo;

import com.fedorov.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        //create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object

            //create a 3 student object
            System.out.println("Creating a 3 student object...");
            Student tempStudent1 = new Student("Aleksandr", "Fedorov", "kajuga@mail.ru");
            Student tempStudent2 = new Student("Olga", "Fedorova", "fedorova@mail.ru");
            Student tempStudent3 = new Student("Max", "Alexeev", "alexeev@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}

