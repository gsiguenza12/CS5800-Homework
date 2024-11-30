package com.company;

public class SnickersDispenseHandler extends SnackDispenseHandler {
    public SnickersDispenseHandler(SnackDispenseHandler next){super(next);}
    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Snickers")) {
            System.out.println("Dispensing Snickers");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from SnickersDispenseHandler");
            super.handle(requestSnack);
        }
    }
}