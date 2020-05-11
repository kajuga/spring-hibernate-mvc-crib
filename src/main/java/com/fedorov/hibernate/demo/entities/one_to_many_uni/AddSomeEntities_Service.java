package com.fedorov.hibernate.demo.entities.one_to_many_uni;

import com.fedorov.hibernate.demo.entities.one_to_many.InstructorDetail_03;
import com.fedorov.hibernate.demo.entities.one_to_many.Instructor_03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddSomeEntities_Service {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor_hb_03.cfg.xml")
                .addAnnotatedClass(Instructor_03.class)
                .addAnnotatedClass(InstructorDetail_03.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor_03 tempInstructor = new Instructor_03("Aleksandr", "Fedorov", "kajuga@mail.ru");
            Instructor_03 tempInstructor2 = new Instructor_03("Olga", "Fedorova", "fedorova@mail.ru");
            Instructor_03 tempInstructor3 = new Instructor_03("Irina", "Orlova", "yahoo@gmail.com");


            //associate the objects
            InstructorDetail_03 tempInstructorDetail = new InstructorDetail_03("Channel", "coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            InstructorDetail_03 tempInstructorDetail2 = new InstructorDetail_03("GoGoGo", "reading");
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            InstructorDetail_03 tempInstructorDetail3 = new InstructorDetail_03("UmUmUm", "sleeping");
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