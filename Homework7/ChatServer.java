package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The mediator class that manages communication between users.
 * It should have methods to register and unregister users,
 * send messages from one user to one or more other users,
 * and block messages from specific users.
 */
public class ChatServer implements ChatMediator {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> blockedUsers = new HashMap<>();

    @Override
    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockedUsers.put(user.getName(), new HashSet<>());
    }

    @Override
    public void unregisterUser(User user) {
        users.remove(user.getName()); // remove user from list of users
        blockedUsers.remove(user.getName()); // remove user from list of blocked users if applicable
    }

    @Override
    public void sendMessage(Message message) {
        for(String recipient : message.getRecipients()){
            if(!blockedUsers.get(recipient).contains(message.getSender())){
                users.get(recipient).receiveMessage(message);
            }
            else{
                System.out.println("Failed to send message: " + "\'" + message.getMessageContent() + "\' \n" + message.getSender() + " has been blocked by " + message.getRecipients());
            }
        }
    }

    @Override
    public void blockUser(User fromUser, User toUser) {
        blockedUsers.get(fromUser.getName()).add(toUser.getName());
        System.out.println(fromUser + " blocked " + toUser);
    }
}