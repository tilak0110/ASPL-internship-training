package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class DarkTextBox implements Textbox{
    @Override
    public void render() {
        System.out.println("rendering Dark theme tect box");
    }
}
