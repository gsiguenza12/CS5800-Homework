package com.company;

import java.time.LocalTime;

/**
 * A class that represents a snapshot of a message sent by a user. It should have properties for the message content
 * and timestamp.
 */
public class MessageMemento {
    private State state;

    MessageMemento(Message message){
           this.state = new State(message);
    }

    // to undo, in external program call getState and replace the current
    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    @Override
    public String toString() {
        return "MessageMemento{" +
                "state=" + state +
                '}';
    }
}
