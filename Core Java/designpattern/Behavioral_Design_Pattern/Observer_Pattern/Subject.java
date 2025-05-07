package designpattern.Behavioral_Design_Pattern.Observer_Pattern;

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}