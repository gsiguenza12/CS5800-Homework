package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private SnackDispenseHandler mockHandler;
    private Snack snack;

    @BeforeEach
    public void setUp() {
        mockHandler = new CokeDispenseHandler(new PepsiDispenseHandler(new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler(new SnickersDispenseHandler(null))))));
        vendingMachine = new VendingMachine(mockHandler);
        snack = new Snack("Chips", 1.5, 10);
        vendingMachine.addSnack(snack);
    }

    @Test
    public void testInitialState() {
        assertTrue(vendingMachine.getCurrentState() instanceof IdleState);
    }

    @Test
    public void testAddSnack() {
        Snack newSnack = new Snack("Chocolate", 2.0, 5);
        vendingMachine.addSnack(newSnack);
        Map<String, Snack> snacks = vendingMachine.getSnacks();
        assertTrue(snacks.containsKey("Chocolate"));
        assertEquals(newSnack, snacks.get("Chocolate"));
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.selectSnack("Chips");
        assertEquals(snack, vendingMachine.getSelectedSnack());
        assertTrue(vendingMachine.getCurrentState() instanceof WaitingForMoneyState);
    }

    @Test
    public void testSelectUnavailableSnack() {
        vendingMachine.selectSnack("Candy");
        assertNull(vendingMachine.getSelectedSnack());
        assertTrue(vendingMachine.getCurrentState() instanceof IdleState);
    }

    @Test
    public void testInsertMoney() {
        vendingMachine.selectSnack("Chips");
        vendingMachine.insertMoney(1.5);
        assertEquals(1.5, vendingMachine.getCurrentMoney());
    }

    @Test
    public void testInvokeHandlerChain() {
        vendingMachine.selectSnack("Chips");
        vendingMachine.insertMoney(1.5);
    }

    @Test
    public void testIdleState() {
        VendingMachineState idleState = new IdleState(vendingMachine);
        vendingMachine.setCurrentState(idleState);
        idleState.handleRequest();
        assertTrue(vendingMachine.getCurrentState() instanceof IdleState);
    }

    @Test
    public void testWaitingForMoneyState() {
        VendingMachineState waitingForMoneyState = new WaitingForMoneyState(vendingMachine);
        vendingMachine.setCurrentState(waitingForMoneyState);
        assertTrue(vendingMachine.getCurrentState() instanceof WaitingForMoneyState);
    }

    @Test
    public void testDispensingState() {
        vendingMachine.selectSnack("Chips");
        VendingMachineState dispensingState = new DispensingState(vendingMachine);
        vendingMachine.setCurrentState(dispensingState);
        assertTrue(vendingMachine.getCurrentState() instanceof DispensingState);
    }
}
