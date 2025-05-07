package designpattern.Behavioral_Design_Pattern.Chain_of_Responsibility_Pattern;

public class Main {
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();


        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // Requests handle karo
        level1.handleRequest("Basic");
        level1.handleRequest("Intermediate");
        level1.handleRequest("Advanced");
        level1.handleRequest("Unknown");  // Koi handle nahi kar payega
    }
}
