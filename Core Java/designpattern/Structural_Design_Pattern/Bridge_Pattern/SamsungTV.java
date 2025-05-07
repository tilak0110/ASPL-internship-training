package designpattern.Structural_Design_Pattern.Bridge_Pattern;

class SamsungTV implements Device {
    public void turnOn() { System.out.println("Samsung: Welcome"); }
    public void setChannel(int n) { System.out.println("Samsung: Go to "+n); }
}
