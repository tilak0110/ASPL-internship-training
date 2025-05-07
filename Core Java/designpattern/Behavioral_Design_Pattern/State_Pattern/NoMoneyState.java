package designpattern.Behavioral_Design_Pattern.State_Pattern;

class NoMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println(amount + " rupees inserted");
        vendingMachine.setCurrentState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Please insert money first");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please insert money first");
    }
}