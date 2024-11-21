package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// TRAFFIC LIGHT IS OBSERVABLE
public class TrafficLight {
//    private static final List<String> COLORS = Arrays.asList("RED", "YELLOW", "GREEN");
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String color = "";

    TrafficLight(String color){
        support.firePropertyChange("color", this.color, color);
        this.color = color;
    }

    public void changeState(){
        if(this.color == "RED"){
            this.color = "GREEN";
        }
        if (this.color == "GREEN"){
            this.color = "YELLOW";
        }
        if (this.color == "YELLOW"){
            this.color = "RED";
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void setStatus(){

    }
}
