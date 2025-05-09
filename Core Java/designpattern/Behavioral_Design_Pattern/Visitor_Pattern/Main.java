package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;
//visitor
public class Main {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[] {
                new Book("Design Patterns", 600),
                new Book("Java Basics", 300),
                new Fruit("Apple", 50, 2),
                new Fruit("Banana", 30, 5)
        };

        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int total = 0;

        for (ItemElement item : items) {
            total += item.accept(visitor);
        }

        System.out.println("\nTotal Cost = " + total);
    }
}