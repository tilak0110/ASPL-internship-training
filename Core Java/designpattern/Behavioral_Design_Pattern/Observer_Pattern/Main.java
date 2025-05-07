package designpattern.Behavioral_Design_Pattern.Observer_Pattern;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer phone = new PhoneDisplay();
        Observer tv = new TVDisplay();

        station.registerObserver(phone);
        station.registerObserver(tv);

        station.setTemperature(25.5f);  // Dono displays ko update milega
        station.setTemperature(30.0f);  // Phir se update
    }
}