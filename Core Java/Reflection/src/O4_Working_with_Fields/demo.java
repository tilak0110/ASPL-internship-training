package Reflection.src.O4_Working_with_Fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class demo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        // Get all fields (including private)
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
            System.out.println("Type: " + field.getType().getSimpleName());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("--------------------------------------------------------------");
        }

        // Get specific field
        try {
            Field nameField = personClass.getDeclaredField("name");
            System.out.println("Found field: " + nameField.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Get and set field values
        Person person = new Person("Alice", 30);
        try {
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true); // for private fields

            // Get value
            int age = (int) ageField.get(person);
            System.out.println("Current age: " + age);

            // Set value
            ageField.set(person, 31);
            System.out.println("New age: " + person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
