package designpattern.Behavioral_Design_Pattern.Momento_Pattern;

class TextMemento {
    private final String text;

    public TextMemento(String textToSave) {
        this.text = textToSave;
    }

    public String getSavedText() {
        return text;
    }
}