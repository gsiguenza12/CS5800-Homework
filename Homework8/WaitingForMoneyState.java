package com.company;

public class WaitingForMoneyState extends VendingMachineState {
    public WaitingForMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Machine is in waiting for money state...");
        Snack snack = vendingMachine.getSelectedSnack();
        if (vendingMachine.getCurrentMoney() >= snack.getPrice() && snack.getQuantity() > 0) {
            System.out.println("Money accepted. Switching machine to dispense state");
            vendingMachine.setCurrentState(new DispensingState(vendingMachine));
            vendingMachine.getCurrentState().handleRequest();
        } else {
            System.out.println("Waiting for money. Please insert the correct amount.");
        }
    }
}