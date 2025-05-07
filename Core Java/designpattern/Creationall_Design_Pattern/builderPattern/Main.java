package designpattern.Creationall_Design_Pattern.builderPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("thick bread")
                .addTopping("pepronii")
                .addTopping("onion")
                .extraCheese(true)
                .extraSpicy(true)
                .build() ;
    }
}
