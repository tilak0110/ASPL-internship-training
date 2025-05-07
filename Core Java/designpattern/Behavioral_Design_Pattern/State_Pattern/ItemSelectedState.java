package designpattern.Behavioral_Design_Pattern.State_Pattern;

class ItemSelectedState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ItemSelectedState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Already has money and item selected");
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Already item selected");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed");
        vendingMachine.setCurrentState(vendingMachine.getNoMoneyState());
    }
}