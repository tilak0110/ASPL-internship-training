package designpattern.Behavioral_Design_Pattern.State_Pattern;

class VendingMachine {
    private VendingMachineState noMoneyState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState currentState;

    public VendingMachine() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        itemSelectedState = new ItemSelectedState(this);
        currentState = noMoneyState;
    }

    public void insertMoney(int amount) {
        currentState.insertMoney(amount);
    }

    public void selectItem(String item) {
        currentState.selectItem(item);
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }


    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getItemSelectedState() {
        return itemSelectedState;
    }
}