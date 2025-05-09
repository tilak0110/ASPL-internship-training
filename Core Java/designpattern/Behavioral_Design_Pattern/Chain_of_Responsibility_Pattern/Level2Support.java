package designpattern.Behavioral_Design_Pattern.Chain_of_Responsibility_Pattern;
//Chain of responsibility
class Level2Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Intermediate")) {
            System.out.println("Level 2 Support handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for this request");
        }
    }
}