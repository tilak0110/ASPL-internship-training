package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class DarkButton implements Button {

    @Override
    public void render() {
        System.out.println("rendering dark theme button");
    }
}
