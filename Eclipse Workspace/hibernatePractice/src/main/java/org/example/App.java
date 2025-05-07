package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Course> courseList= new ArrayList<>();

        Course course1= new Course("Maths");
        Course course2= new Course("Arts");
        courseList.add(course1);
        courseList.add(course2);
        Student student=new Student(courseList,"Mahendra");




        session.beginTransaction();

        session.save(course1);
        session.save(course2);

       session.save(student);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
