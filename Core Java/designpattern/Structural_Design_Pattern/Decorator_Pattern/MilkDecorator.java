package designpattern.Structural_Design_Pattern.Decorator_Pattern;

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) { super(coffee); }

    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + " + Milk";
    }
}