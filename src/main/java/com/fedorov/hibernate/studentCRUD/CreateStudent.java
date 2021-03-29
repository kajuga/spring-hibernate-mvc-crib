package com.fedorov.hibernate.studentCRUD;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class CreateStudent {


    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            Student tempStudent = new Student();
            tempStudent.setFirstName("Aleksandr");
            tempStudent.setLastName("Fedorov");
            tempStudent.setEmail("kajuga@mai.ru");
            session.beginTransaction();


            session.save(tempStudent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
