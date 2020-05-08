package com.fedorov.hibernate.demo.hb_eager_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddSomeEntities_Service {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_EL.class)
                .addAnnotatedClass(InstructorDetail_EL.class)
                .addAnnotatedClass(Course_EL.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor_EL tempInstructor = new Instructor_EL("Aleksandr", "Fedorov", "kajuga@mail.ru");
            Instructor_EL tempInstructor2 = new Instructor_EL("Olga", "Fedorova", "fedorova@mail.ru");
            Instructor_EL tempInstructor3 = new Instructor_EL("Irina", "Orlova", "yahoo@gmail.com");


            //associate the objects
            InstructorDetail_EL tempInstructorDetail = new InstructorDetail_EL("Channel", "coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            InstructorDetail_EL tempInstructorDetail2 = new InstructorDetail_EL("GoGoGo", "reading");
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            InstructorDetail_EL tempInstructorDetail3 = new InstructorDetail_EL("UmUmUm", "sleeping");
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