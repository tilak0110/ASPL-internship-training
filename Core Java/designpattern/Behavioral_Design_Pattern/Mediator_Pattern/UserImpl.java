package designpattern.Behavioral_Design_Pattern.Mediator_Pattern;

class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Sending Message: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Received Message: " + msg);
    }
}