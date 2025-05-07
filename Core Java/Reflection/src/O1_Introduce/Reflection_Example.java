package Reflection.src.O1_Introduce;

import java.util.Collections;

public class Reflection_Example {
    public static void main(String[] args) {
        Class<?> clazz = String.class ;
        System.out.println(clazz.getName());

        Class<?> clazz1 = Object.class ;
        System.out.println(clazz1.getName());

        Class<?> clazz2 = Collections.class ;
        System.out.println(clazz2.getName());
    }
}
