package com.fedorov.hibernate.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //DELETE student id= 1 from database
            int studentId =1;
            session= factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);

            //another way: DELETE student id=2 from database ON FLY
            session.createQuery("DELETE from Student where id=2").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("\n\nDone, student delete!");
        }
        finally {
            factory.close();
        }


    }
}




















