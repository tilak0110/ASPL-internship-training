package Reflection.src.O7_Accessing_Private_Members;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AccessPrivateDemo {
    public static void main(String[] args) {
        try {
            Secret secret = new Secret();
            Class<?> secretClass = secret.getClass();

            // Access private field
            Field secretField = secretClass.getDeclaredField("secretCode");
            secretField.setAccessible(true); // game changer step hai ye
            String code = (String) secretField.get(secret);
            System.out.println("Secret code: " + code);

            // Change private field
            secretField.set(secret, "54321");

            // Access private method
            Method[] secretMethods = secretClass.getDeclaredMethods();
            for(Method m : secretMethods){
                System.out.println(m.getName());
                System.out.println(m.getReturnType().getName());
                System.out.println(Modifier.isPrivate(m.getModifiers()));
            }
            Method secretMethod = secretClass.getDeclaredMethod("showSecret");
            secretMethod.setAccessible(true);
            secretMethod.invoke(secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
