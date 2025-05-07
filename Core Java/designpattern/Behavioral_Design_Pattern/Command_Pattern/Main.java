package designpattern.Behavioral_Design_Pattern.Command_Pattern;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        remote.setCommand(lightOn);
        remote.pressButton();  // Light ON
        remote.pressUndo();    // Light OFF

        remote.setCommand(lightOff);
        remote.pressButton();  // Light OFF
        remote.pressUndo();    // Light ON
    }
}