package com.fedorov.hibernate.hb_04_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddSomeEntities_Service {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_04.class)
                .addAnnotatedClass(InstructorDetail_04.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor_04 tempInstructor = new Instructor_04("Aleksandr", "Fedorov", "kajuga@mail.ru");
            Instructor_04 tempInstructor2 = new Instructor_04("Olga", "Fedorova", "fedorova@mail.ru");
            Instructor_04 tempInstructor3 = new Instructor_04("Irina", "Orlova", "yahoo@gmail.com");


            //associate the objects
            InstructorDetail_04 tempInstructorDetail = new InstructorDetail_04("Channel", "coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            InstructorDetail_04 tempInstructorDetail2 = new InstructorDetail_04("GoGoGo", "reading");
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            InstructorDetail_04 tempInstructorDetail3 = new InstructorDetail_04("UmUmUm", "sleeping");
            tempInstructor3.setInstructorDetail(tempInstructorDetail3);

            //start a transaction
            session.beginTransaction();

            //save the instructor. Also save the details object cause CascadeType.ALL
            System.out.println("Saving the instructors: " + tempInstructor);
            session.save(tempInstructor);
            session.save(tempInstructor2);
            session.save(tempInstructor3);

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