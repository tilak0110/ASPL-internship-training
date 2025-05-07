package designpattern.Behavioral_Design_Pattern.Momento_Pattern;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setText("First line");
        history.push(editor.save());

        editor.setText("Second line");
        history.push(editor.save());

        editor.setText("Third line");
        System.out.println("Current text: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("After undo: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("After second undo: " + editor.getText());
    }
}