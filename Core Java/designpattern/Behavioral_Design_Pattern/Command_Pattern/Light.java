package designpattern.Behavioral_Design_Pattern.Command_Pattern;

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(designpattern.Behavioral_Design_Pattern.Command_Pattern.Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}