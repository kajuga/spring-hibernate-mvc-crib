package com.fedorov.hibernate.studentCRUD;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("SELECT s FROM Student s").getResultList();
            for (Student s: theStudents) {
                System.out.println(s);
            }
            System.out.println("Second query result:");
            List<Student> theStudents2 = session.createQuery("SELECT s FROM Student s WHERE first_name='Aleksandr'").getResultList();
            for (Student s: theStudents2) {
                System.out.println(s);
            }
//            "SELECT s FROM Student s WHERE s.first_name='Aleksandr' OR s.last_name='Fedorov2'"
//            "SELECT s FROM Student s WHERE s.email LIKE '%@mail.ru'"
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }


}














