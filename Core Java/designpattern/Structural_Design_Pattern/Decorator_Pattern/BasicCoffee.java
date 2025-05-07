package designpattern.Structural_Design_Pattern.Decorator_Pattern;

class BasicCoffee implements Coffee {
    public double getCost(){
        return 2.0;
    }
    public String getDescription() {
        return "Basic Coffee";
    }
}