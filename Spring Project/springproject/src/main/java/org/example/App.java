package org.example;

import org.example.model.Employee;
import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        Person employee= (Employee) context.getBean("employee");
        employee.test();
        System.out.println(employee);

        System.out.println( "Hello World!" );
    }
}
