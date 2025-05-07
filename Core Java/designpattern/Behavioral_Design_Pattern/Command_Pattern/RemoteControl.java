package designpattern.Behavioral_Design_Pattern.Command_Pattern;

class RemoteControl {
    private Command command;

    public void setCommand(Command cmd) {
        this.command = cmd;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}