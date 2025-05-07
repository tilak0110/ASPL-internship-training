package designpattern.Structural_Design_Pattern.Bridge_Pattern;

class BasicRemote extends RemoteControl {
    BasicRemote(Device device) { super(device); }

    void powerOn() {
        device.turnOn();
        device.setChannel(1);
    }
}