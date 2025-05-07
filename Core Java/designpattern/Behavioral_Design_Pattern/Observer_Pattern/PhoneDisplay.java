package designpattern.Behavioral_Design_Pattern.Observer_Pattern;

class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Temperature updated to " + temperature);
    }
}