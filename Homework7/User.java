package com.company;

import java.util.Iterator;
import java.util.List;

/**
 *  A class representing a user of the chat application. It should have methods to send messages to other users,
 *  receive messages from other users, and undo the last message sent. NOTE: You will NOT communicate with other
 *  Users directly you will use Mediator
 */
public class User {
    private String name;
    private ChatMediator mediator;
    private ChatHistory chatHistory = new ChatHistory();

    @Override
    public String toString() {
        return name;
    }

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.registerUser(this);
    }

    public String getName(){
        return name;
    }

    public void sendMessage(List<String> recipients, String content){
        Message message = new Message(name, recipients, content);
        for(String recipient : recipients) {
            chatHistory.addMessage(new MessageMemento(message), recipient);
        }
        mediator.sendMessage(message);
    }

    public void undoLastMessage(){
        MessageMemento lastMessage = chatHistory.getLastMessage();
        if(lastMessage !=null) {
            System.out.println(name + " undid the message: " + lastMessage.getState());
        } else {
            System.out.println("No message to undo for " + name);
        }
    }

    public void blockUser(User user) {
        mediator.blockUser(this, user);
    }

    public void receiveMessage(Message message){
        System.out.println(name + " received a message from " + message.getSender() + ": " + message.getMessageContent());
    }

    public void iterateMessageHistoryByUser(User user) {
        Iterator<MessageMemento> iterator = chatHistory.iterator(user);
        // for debugging
//        chatHistory.printHistory();
//        System.out.println(iterator.hasNext());
        while(iterator.hasNext()) {
            MessageMemento memento = iterator.next();
            System.out.println(name + " iterates over message from " + user.getName() + ": " + memento.getState());
        }
        System.out.println("reached the end of chat history");
    }

    public void printChatHistory() {
        chatHistory.printHistory();
    }
}