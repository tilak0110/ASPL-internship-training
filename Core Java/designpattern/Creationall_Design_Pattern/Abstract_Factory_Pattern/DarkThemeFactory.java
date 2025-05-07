package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class DarkThemeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Textbox createTextBox() {
        return new DarkTextBox();
    }
}
