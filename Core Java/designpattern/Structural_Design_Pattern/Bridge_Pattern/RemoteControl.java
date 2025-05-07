package designpattern.Structural_Design_Pattern.Bridge_Pattern;

abstract class RemoteControl {
    protected Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    abstract void powerOn();
}