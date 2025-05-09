package designpattern.Behavioral_Design_Pattern.Visitor_Pattern;
//visitor
interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
