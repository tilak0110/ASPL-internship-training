package designpattern.Behavioral_Design_Pattern.Mediator_Pattern;

import java.util.ArrayList;
import java.util.List;

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : users) {
            // Message sender ko nahi bhejna
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}