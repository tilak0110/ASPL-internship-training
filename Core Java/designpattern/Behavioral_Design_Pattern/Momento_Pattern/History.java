package designpattern.Behavioral_Design_Pattern.Momento_Pattern;

import java.util.ArrayList;
import java.util.List;

class History {
    private List<TextMemento> states = new ArrayList<>();

    public void push(TextMemento memento) {
        states.add(memento);
    }

    public TextMemento pop() {
        if (states.isEmpty()) {
            return null;
        }
        TextMemento lastState = states.get(states.size() - 1);
        states.remove(lastState);
        return lastState;
    }
}