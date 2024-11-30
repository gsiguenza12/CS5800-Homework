package com.company;

/**
 * State and Chain of Responsibility
 * Vending machine starts in idle state. User should select a snack, selectSnack(),
 * from Vending Machine.
 * Vending machine should wait for user to insert money, insertMoney().
 *
 * If money inserted is >= price
 *      then dispense item if enough quantity or return money.
 * To dispense snack, the VendingMachine class should call the dispenseSnack()
 * method on the current state object. The state object will handle the event
 * and transition to the appropriate state based on the availability of snacks.
 *
 * Create driver with 6 different snacks and Chain of Responsibility in this order
 * ->Coke, Pepsi, Cheetos, Doritos, KitKat, and Snickers.
 *
 * Your driver should include at least one case where the quantity hits 0 with snickers.
 */
public class Main {

    public static void main(String[] args) {
        // Create driver with 6 different snacks and Chain of Responsibility in this order ->Coke, Pepsi, Cheetos, Doritos, KitKat, and Snickers.
        SnackDispenseHandler chain = new CokeDispenseHandler(new PepsiDispenseHandler(new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler(new SnickersDispenseHandler(null))))));
        VendingMachine machine = new VendingMachine(chain);

        // add snacks to vendingmachine
        machine.addSnack(new Snack("Coke", 2.99,10));
        machine.addSnack(new Snack("Pepsi",2.99,10));
        machine.addSnack(new Snack("Cheetos",3.75,10));
        machine.addSnack(new Snack("Doritos",3.75,10));
        machine.addSnack(new Snack("KitKat",1.99,10));
        machine.addSnack(new Snack("Snickers",1.99,1));

        // buying the last snickers
        machine.selectSnack("Snickers");
        machine.insertMoney(2.99);

        // attempting to purchase another snickers
        machine.selectSnack("Snickers");
        machine.insertMoney(2.99);

        System.out.println(machine.getSnacks());
    }
}