package designpattern.Structural_Design_Pattern.Flyweight_Pattern;

public class Main {
    public static void main(String[] args) {
        TextStyle style1 = TextStyleFactory.getStyle("Arial", 12, false);
        TextStyle style2 = TextStyleFactory.getStyle("Arial", 12, false);
    }
}
