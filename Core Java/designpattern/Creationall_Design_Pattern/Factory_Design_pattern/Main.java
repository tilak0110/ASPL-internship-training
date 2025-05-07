package designpattern.Creationall_Design_Pattern.Factory_Design_pattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new Car_Factory();
        factory.prepareVehicle();
    }
}
