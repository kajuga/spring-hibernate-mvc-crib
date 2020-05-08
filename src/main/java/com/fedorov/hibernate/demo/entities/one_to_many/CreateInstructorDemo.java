package com.fedorov.hibernate.demo.entities.one_to_many;

import com.fedorov.hibernate.demo.entities.one_to_one_uni.Instructor;
import com.fedorov.hibernate.demo.entities.one_to_one_uni.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_03.class)
                .addAnnotatedClass(InstructorDetail_03.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor_03 tempInstructor = new Instructor_03("Sashok", "Ramboshok", "yahoo@gmail.ru");
            InstructorDetail_03 tempInstructorDetail = new InstructorDetail_03("http://www.youtube.com", "Fitness");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor. Also save the details object cause CascadeType.ALL
            System.out.println("Saving the instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }
}












