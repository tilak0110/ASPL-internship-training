package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("rendering light theme ");
    }
}
