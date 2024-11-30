package com.company;

abstract class VendingMachineState { // abstract class that stores an instance of the object it is acting on
    protected VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void handleRequest();
}