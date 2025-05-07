package Reflection.src.O3_Inspecting_class_information;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Inspecting_Example {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class ;
        System.out.println("class name "+ personClass.getName());
        System.out.println("class name "+ personClass.getSimpleName());

      int modifiers =   personClass.getModifiers() ;
        System.out.println(Modifier.isPublic(modifiers));
        System.out.println(Modifier.isPrivate(modifiers));
        System.out.println(Modifier.isStatic(modifiers));
        System.out.println(Modifier.isSynchronized(modifiers));

        Package pkg = personClass.getPackage();
        System.out.println("Package: " + pkg.getName());

        System.out.println("Superclass: " + personClass.getSuperclass().getName());

        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println("Interfaces: " + Arrays.toString(interfaces));
    }
}
