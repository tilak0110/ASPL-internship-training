package designpattern.Behavioral_Design_Pattern.Template_Method_Pattern;

class WoodenHouse extends HouseTemplate {
    @Override
    public void buildPillars() {
        System.out.println("Building pillars with wood coating");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building wooden walls");
    }
}