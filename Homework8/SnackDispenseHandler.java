package com.company;

/**
 * Base class contains boilerplate code common to all handlers
 */
public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next){this.next = next;}

    public void handle(Snack requestSnack){
        if(next != null){
            next.handle(requestSnack);
        }
    }
}
