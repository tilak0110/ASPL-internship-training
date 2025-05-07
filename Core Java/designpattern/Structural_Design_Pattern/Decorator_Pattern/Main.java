package designpattern.Structural_Design_Pattern.Decorator_Pattern;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new BasicCoffee());
        System.out.println(coffee.getDescription() + ": $" + coffee.getCost());
    }
}
