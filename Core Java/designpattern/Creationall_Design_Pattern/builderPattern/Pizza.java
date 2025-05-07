package designpattern.Creationall_Design_Pattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String base ;
    private List<String> toppings = new ArrayList<>();
    private boolean extraCheese;
    private boolean extraSpicy ;

    private Pizza(PizzaBuilder builder) {
        this.base = builder.base;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
        this.extraSpicy = builder.extraSpicy;
    }


    public static class PizzaBuilder {
        private String base;
        private List<String> toppings = new ArrayList<>();
        private boolean extraCheese;
        private boolean extraSpicy;

        public PizzaBuilder(String base) {
            this.base = base;
        }

        public PizzaBuilder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder extraCheese(boolean value) {
            this.extraCheese = value;
            return this;
        }

        public PizzaBuilder extraSpicy(boolean value) {
            this.extraSpicy = value;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }

    }


}
