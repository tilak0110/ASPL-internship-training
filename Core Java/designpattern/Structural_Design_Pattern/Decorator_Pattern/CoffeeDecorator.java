package designpattern.Structural_Design_Pattern.Decorator_Pattern;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
}