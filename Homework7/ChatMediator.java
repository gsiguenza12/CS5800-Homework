package com.company;

public interface ChatMediator {
    void registerUser(User user);
    void unregisterUser(User user);
    void sendMessage(Message message);
    void blockUser(User fromUser, User toUser);

}
