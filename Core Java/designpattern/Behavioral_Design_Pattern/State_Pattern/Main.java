package designpattern.Behavioral_Design_Pattern.State_Pattern;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.selectItem("Coke");  // Money nahi daala hai
        vm.insertMoney(20);     // Money daali
        vm.selectItem("Coke"); // Item select kiya
        vm.dispenseItem();     // Item mil gaya
    }
}