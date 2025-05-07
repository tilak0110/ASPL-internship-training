package designpattern.Behavioral_Design_Pattern.Mediator_Pattern;

interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}