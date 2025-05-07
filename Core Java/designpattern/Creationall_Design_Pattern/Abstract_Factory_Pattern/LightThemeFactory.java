package designpattern.Creationall_Design_Pattern.Abstract_Factory_Pattern;

public class LightThemeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Textbox createTextBox() {
        return new LightTextbox();
    }
}
