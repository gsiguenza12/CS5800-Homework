package com.company;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car extends Vehicle implements PropertyChangeListener{

    String trafficLightStatus = "";

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        trafficLightStatus = (String)event.getNewValue();
    }

    public void react(Reactor reactor){
        reactor.react(trafficLightStatus);
    }


}
