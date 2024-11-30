package com.company;

public class DispensingState extends VendingMachineState { // concrete state class provides its own implementation for state specific methods
    public DispensingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("The machine is in dispensing state...");
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        if (selectedSnack != null && selectedSnack.getQuantity() > 0) {
            vendingMachine.invokeHandlerChain(selectedSnack);
        } else {
            System.out.println(vendingMachine.getSelectedSnack().getName() + " is out of stock, please make another choice.");
        }
        System.out.println("Switching machine back to idle state...");
        vendingMachine.setCurrentState(new IdleState(vendingMachine)); // switch current state back to idle state
        vendingMachine.getCurrentState().handleRequest();
    }
}