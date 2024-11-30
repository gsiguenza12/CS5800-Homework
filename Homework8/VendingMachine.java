package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Should reference STATE of Vending Machine and SNACKDISPENSER plus hold all snacks.
 */
public class VendingMachine {
    private final Map<String, Snack> snacks = new HashMap<>();
    private final SnackDispenseHandler handlerChain;
    private VendingMachineState currentState;
    private Snack selectedSnack;
    private double currentMoney;

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public VendingMachine(SnackDispenseHandler chain) {
        this.handlerChain = chain; // set chain of command
        currentState = new IdleState(this); // Vending machine starts in the Idle state
        currentState.handleRequest();
    }

    public void addSnack(Snack snack){
        snacks.put(snack.getName(),snack);
    }

    public void selectSnack(String snackName) {
        System.out.println("Snack selected: " + snackName);
        if (snacks.containsKey(snackName) && snacks.get(snackName).getQuantity() > 0) {
            this.selectedSnack = snacks.get(snackName);
            System.out.println("Setting selection to: " + snackName);
            currentState = new WaitingForMoneyState(this);
            System.out.println("Price for selection: $" + selectedSnack.getPrice());
            System.out.println("Please insert money");
        } else {
            System.out.println("Snack not available. Please select another snack.");
        }
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void invokeHandlerChain(Snack snack){
        System.out.println("Handler chain invoked...");
        handlerChain.handle(snack);
    }

    public void insertMoney(double money) {
        // add money to vending machine
        currentMoney += money;
        currentState.handleRequest();
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public Map<String, Snack> getSnacks() {
        return snacks;
    }

}