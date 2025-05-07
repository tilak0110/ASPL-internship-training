package designpattern.Behavioral_Design_Pattern.Template_Method_Pattern;

class GlassHouse extends HouseTemplate {
    @Override
    public void buildPillars() {
        System.out.println("Building pillars with glass coating");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building glass walls");
    }

    @Override
    public void buildWindows() {
        System.out.println("Building large glass windows");
    }
}