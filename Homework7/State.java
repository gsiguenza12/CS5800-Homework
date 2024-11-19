package com.company;


import java.time.LocalTime;

public class State {
    private String messageContent;
    private LocalTime timestamp;

    State(Message message){
        setState(message);
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setState(Message message) {
        setMessageContent(message.getMessageContent());
        setTimestamp(message.getTimestamp());
    }

    @Override
    public String toString() {
        return "State{" +
                "messageContent='" + messageContent + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
