package com.company;

public class CheetosDispenseHandler extends SnackDispenseHandler {
    public CheetosDispenseHandler(SnackDispenseHandler next){super(next);}

    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Cheetos")) {
            System.out.println("Dispensing Cheetos");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from CheetosDispenseHandler");
            next.handle(requestSnack);
        }
    }
}