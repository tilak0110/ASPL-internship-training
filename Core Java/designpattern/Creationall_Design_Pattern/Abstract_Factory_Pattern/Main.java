package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new DarkThemeFactory() ;
        Button button = factory.createButton();
        Textbox txtbox = factory.createTextBox() ;
        button.render();
        txtbox.render();
    }
}
