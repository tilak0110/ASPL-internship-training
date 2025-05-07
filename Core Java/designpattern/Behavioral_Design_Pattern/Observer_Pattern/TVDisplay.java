package designpattern.Behavioral_Design_Pattern.Observer_Pattern;

class TVDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TV Display: Current temperature is " + temperature);
    }
}
