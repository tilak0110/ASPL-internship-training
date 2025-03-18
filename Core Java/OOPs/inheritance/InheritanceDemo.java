package OOPs.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.fuel();  // Inherited from Vehicle
        car.drive();
    }
}