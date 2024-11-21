package com.company;

public class Aggressive implements Reactor{
    @Override
    public String react(String status) {
        if(status == "RED"){ return "SLAM BRAKES";}
        if(status == "YELLOW"){return "FASTER";}
        if(status == "GREEN"){return "NEED4SPEED";}
        return "";
    }
}
