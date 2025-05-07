package designpattern.Behavioral_Design_Pattern.State_Pattern;

class HasMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Already has money");
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Selected item: " + item);
        vendingMachine.setCurrentState(vendingMachine.getItemSelectedState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select item first");
    }
}