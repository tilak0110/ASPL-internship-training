package designpattern.Structural_Design_Pattern.Bridge_Pattern;

public class Main {
    public static void main(String[] args) {
        Device sony = new SonyTV();
        RemoteControl remote = new BasicRemote(sony);
        remote.powerOn();
    }
}
