package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;

interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
