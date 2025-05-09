package designpattern.Behavioral_Design_Pattern.Chain_of_Responsibility_Pattern;
//Chain of responsibility
interface SupportHandler {
    void setNextHandler(SupportHandler nextHandler);
    void handleRequest(String request);
}
