package designpattern.Behavioral_Design_Pattern.Mediator_Pattern;

public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Shubham");
        User user2 = new UserImpl(mediator, "Saurabh");
        User user3 = new UserImpl(mediator, "Sahil");
        User user4 = new UserImpl(mediator, "sumit");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi all");
        user3.send("Hello everyone");
    }
}