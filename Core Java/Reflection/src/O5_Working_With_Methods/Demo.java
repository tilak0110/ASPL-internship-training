package Reflection.src.O5_Working_With_Methods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        // Get all methods
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getName());
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("-----------------------------------------------------------------------");

            // Get parameter types
            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.println("Parameters: " + Arrays.toString(paramTypes));}

        // Get specific method
        try {
            Method greetMethod = personClass.getMethod("greet");
            System.out.println("Found method: " + greetMethod.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        }



}
