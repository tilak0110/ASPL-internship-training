package Reflection.src.O11_Proxies_and_dynamic_Interface;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        Greet greeter = (Greet) Proxy.newProxyInstance(
                Greet.class.getClassLoader(),
                new Class<?>[] { Greet.class },
                (proxy, method, args1) -> {
                    System.out.println("Hello, " + args1[0] + "!");
                    return null;
                }
        );

        greeter.greet("Tilak");
        greeter.greet("Sumit");
    }
}
