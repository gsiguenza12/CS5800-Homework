package com.company;

public class KitKatDispenseHandler extends SnackDispenseHandler {
    public KitKatDispenseHandler(SnackDispenseHandler next){super(next);}

    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("KitKat")) {
            System.out.println("Dispensing KitKat");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from KitKatDispenseHandler");
            super.handle(requestSnack);
        }
    }
}