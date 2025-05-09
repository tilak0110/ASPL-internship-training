package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;
//visitor
interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
