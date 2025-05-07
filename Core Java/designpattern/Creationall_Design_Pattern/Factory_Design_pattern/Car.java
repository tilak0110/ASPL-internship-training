package designpattern.Creationall_Design_Pattern.Factory_Design_pattern;

public class Car implements Vehicle{
    @Override
    public void assemble() {
        System.out.println("i want 4 wheels , 4 seats . one engine");
    }
}
