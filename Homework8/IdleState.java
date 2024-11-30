package com.company;

public class IdleState extends VendingMachineState {
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Machine is idle. Please select a snack.");
    }
}
