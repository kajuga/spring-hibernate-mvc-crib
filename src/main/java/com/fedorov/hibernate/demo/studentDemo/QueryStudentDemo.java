package com.fedorov.hibernate.demo.studentDemo;

import com.fedorov.hibernate.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

//            display the students
            displayStudents(theStudents);
            System.out.println("\n");


            //query students: firstName = 'Aleksandr'
            theStudents = session.createQuery("from Student s where s.firstName = 'Aleksandr'").getResultList();
            displayStudents(theStudents);
            System.out.println("\n");


            //query students: lastName='Fedorov' or firstName='Olga'
            theStudents=session.createQuery("from Student s where s.lastName='Fedorov' OR s.firstName='Olga'").getResultList();
            displayStudents(theStudents);

            System.out.println("\n");
            //query students: where email LIKE '%mail.ru'

            theStudents=session.createQuery("FROM Student s WHERE s.email LIKE '%mail.ru'").getResultList();
            displayStudents(theStudents);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println("Student: " + tempStudent);
        }
    }
}







