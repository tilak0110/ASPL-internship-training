package Reflection.src.O2_Get_class_objects;

import java.util.Comparator;

public class Get_object_example {
    public static void main(String[] args) {
        //three way to get a class object

        // first
        Class<?> clazz = Comparator.class ;  //using .class syntax

        //second
        String str = "tilak" ;
        Class<?> strclass = str.getClass() ; // using getClass() method

        //Third

        try{
            Class<?> claz = Class.forName("java.util.ArrayList");
            System.out.println(claz);
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }

        System.out.println(clazz);
        System.out.println(strclass);


    }
}
