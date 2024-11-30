package com.company;

public class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler next){super(next);}
    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Coke")) {
            System.out.println("Dispensing Coke");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from CokeDispenseHandler");
            super.handle(requestSnack);
        }
    }
}