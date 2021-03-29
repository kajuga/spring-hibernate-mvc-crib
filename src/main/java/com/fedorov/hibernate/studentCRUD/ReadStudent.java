package com.fedorov.hibernate.studentCRUD;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Student readStudent = session.get(Student.class, 2);
            session.getTransaction().commit();

            System.out.println(readStudent.getFirstName());
            System.out.println(readStudent.getLastName());
            System.out.println(readStudent.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
