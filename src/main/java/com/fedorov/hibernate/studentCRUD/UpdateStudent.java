package com.fedorov.hibernate.studentCRUD;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int studentId = 2;

            Student readStudent = session.get(Student.class, studentId);
            readStudent.setFirstName("Ololosha");

// session.createQuery("UPDATE Student SET email='fedorovs@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println(readStudent.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}









