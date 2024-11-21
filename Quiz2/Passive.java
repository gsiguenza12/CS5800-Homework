package com.company;

public class Passive implements Reactor{
    @Override
    public String react(String status) {
        if(status == "RED"){ return "stop";}
        if(status == "YELLOW"){return "slower";}
        if(status == "GREEN"){return "go slow";}
        return "";
    }
}
