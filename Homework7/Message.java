package com.company;

import java.time.LocalTime;
import java.util.List;

/**
 * A class representing a message sent by a user. It should have properties
 * for the sender, recipient(s), timestamp, and message content.
 */
public class Message {
    private String sender;
    private List<String> recipients;
    private LocalTime timestamp;
    private String messageContent;

    // default constructor, just set the timestamp
    public Message(){
        this.timestamp = LocalTime.now();
    }

    public Message(String sender, List<String> recipients, String messageContent) {
        // set programmatically
        this.sender = sender;
        this.recipients = recipients;
        this.messageContent = messageContent;

        // set by system
        this.timestamp = LocalTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }


    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", recipients='" + recipients + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
