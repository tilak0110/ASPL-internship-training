package designpattern.Behavioral_Design_Pattern.Template_Method_Pattern;
//Template
public class Main {
    public static void main(String[] args) {
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        System.out.println("\nBuilding glass house:");
        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }
}