package com.company;

public class PepsiDispenseHandler extends SnackDispenseHandler {
    public PepsiDispenseHandler(SnackDispenseHandler next){super(next);}

    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Pepsi")) {
            System.out.println("Dispensing Pepsi");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from PepsiDispenseHandler");
            super.handle(requestSnack);
        }
    }
}