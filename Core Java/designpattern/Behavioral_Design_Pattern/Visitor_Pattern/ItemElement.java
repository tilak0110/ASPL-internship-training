package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;

interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
