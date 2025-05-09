package designpattern.Behavioral_Design_Pattern.Chain_of_Responsibility_Pattern;
//Chain of responsibility
class Level3Support implements SupportHandler {
    @Override
    public void setNextHandler(SupportHandler nextHandler) {
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Advanced")) {
            System.out.println("Level 3 Support handled the request");
        } else {
            System.out.println("No handler available for this request");
        }
    }
}
