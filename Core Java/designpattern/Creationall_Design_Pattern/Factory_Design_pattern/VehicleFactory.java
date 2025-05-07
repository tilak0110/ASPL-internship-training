package designpattern.Creationall_Design_Pattern.Factory_Design_pattern;

public  abstract  class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void prepareVehicle(){
        Vehicle v = createVehicle() ;
        v.assemble(); ;
    }
}
