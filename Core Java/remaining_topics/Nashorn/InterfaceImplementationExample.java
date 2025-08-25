package remaining_topics.Nashorn;

import javax.script.*;
import java.io.*;

public class InterfaceImplementationExample {

    // Step 1: Define a Java interface
    public static interface Pet {
        public void eat();
    }

    public static void main(String[] args) throws Exception {
        // Step 2: Get a Nashorn script engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            // Step 3: Run JavaScript from file that implements the interface
            Pet pet = (Pet) engine.eval(new FileReader("pet.js"));

            // Step 4: Call the method
            pet.eat();

        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
    }
}

