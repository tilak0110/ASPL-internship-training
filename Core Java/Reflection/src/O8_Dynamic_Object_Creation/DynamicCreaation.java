package Reflection.src.O8_Dynamic_Object_Creation;

import java.util.List;

public class DynamicCreaation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");

            List<String> list = (List<String>) clazz.getDeclaredConstructor().newInstance();
            list.add("khana");

            // Use the object
            System.out.println("List class: " + list.getClass().getName());
            System.out.println("List size: " + list.size());
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
