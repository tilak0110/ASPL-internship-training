package Reflection.src.O10_Arrays_and_Reflection;

import java.lang.reflect.Array;

public class Demo {
    public static void main(String[] args) {
        // Create array dynamically
        int[] intArray = (int[]) Array.newInstance(int.class, 5);

        // Set values
        for (int i = 0; i < Array.getLength(intArray); i++) {
            Array.set(intArray, i, i * 10);
        }

        // Get values
        for (int i = 0; i < Array.getLength(intArray); i++) {
            System.out.println(Array.get(intArray, i));
        }

        // Get component type
        Class<?> componentType = intArray.getClass().getComponentType();
        System.out.println("Component type: " + componentType.getName());
    }
}
