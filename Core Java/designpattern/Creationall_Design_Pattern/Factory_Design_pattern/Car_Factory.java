package designpattern.Creationall_Design_Pattern.Factory_Design_pattern;

public class Car_Factory extends VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
