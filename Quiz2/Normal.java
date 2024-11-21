package com.company;

public class Normal implements Reactor{
    @Override
    public String react(String status) {
        if(status == "RED"){ return "Stop";}
        if(status == "YELLOW"){return "Slow";}
        if(status == "GREEN"){return "Go";}
        return "";
    }
}
