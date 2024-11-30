package com.company;

public class DoritosDispenseHandler extends SnackDispenseHandler {
    public DoritosDispenseHandler(SnackDispenseHandler next){super(next);}

    @Override
    public void handle(Snack requestSnack) {
        if (requestSnack.getName().equalsIgnoreCase("Doritos")) {
            System.out.println("Dispensing Doritos");
            requestSnack.dispense();
        } else if (next != null) {
            System.out.println("I was passed from DoritosDispenseHandler");
            super.handle(requestSnack);
        }
    }
}
