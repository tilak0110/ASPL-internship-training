package designpattern.Behavioral_Design_Pattern.State_Pattern;

interface VendingMachineState {
    void insertMoney(int amount);
    void selectItem(String item);
    void dispenseItem();
}