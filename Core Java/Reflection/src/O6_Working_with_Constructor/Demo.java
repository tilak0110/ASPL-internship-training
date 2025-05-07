package Reflection.src.O6_Working_with_Constructor;

import java.lang.reflect.Constructor;

public class Demo {

    public static void main(String[] args) {

        Class<Person> personClass = Person.class;

// Get all constructors
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
            System.out.println("Parameter count: " + constructor.getParameterCount());
        }

// Get specific constructor and create instance
        try {
            Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
            Person person = constructor.newInstance("Tilak", 24);
            person.greet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
