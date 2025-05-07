package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        if (cost > 500) {
            cost = cost - (cost * 5 / 100);
        }
        System.out.println("Book: " + book.getName() + ", cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + ", cost = " + cost);
        return cost;
    }
}
