package designpattern.Structural_Design_Pattern.Bridge_Pattern;

class SonyTV implements Device {
    public void turnOn() { System.out.println("Sony: Power ON"); }
    public void setChannel(int n) { System.out.println("Sony: Channel "+n); }
}