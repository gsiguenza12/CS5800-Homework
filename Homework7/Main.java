package com.company;

import java.util.Arrays;

/**
 * Your program should demonstrate the following features:
 * Users can send messages to one or more other users through the chat server.
 * Users can undo the last message they sent using the Memento design pattern.
 * Users can block messages from specific users using the Mediator design pattern.
 * Users can receive messages from other users and view the chat history for a specific user.
 * Your program should include a driver that demonstrates these features with 3 users.
 */
public class Main {

    public static void main(String[] args) {
        ChatMediator chatServer = new ChatServer();
        User gabe = new User("Gabe", chatServer);
        User riley = new User("Riley", chatServer);
        User steven = new User("Steve", chatServer);

        chatServer.registerUser(gabe);
        chatServer.registerUser(riley);
        chatServer.registerUser(steven);

        gabe.sendMessage(Arrays.asList("Riley", "Steve"), "Hello, what are you guys doing for dinner tonight?");
        System.out.println();
        riley.sendMessage(Arrays.asList("Gabe"), "Hey, im not really trying to hang out with Steve tonight.");
        System.out.println();
        steven.sendMessage(Arrays.asList("Gabe","Steve"), "Oh Hey guys! no plans right now but I'd love to see you guys, especially Riley!");
        System.out.println();
        riley.sendMessage(Arrays.asList("Gabe","Steve"), "Oh ya! Good to hear from you Stevie! Um... let me check my schedule for tonight");
        System.out.println();
        riley.sendMessage(Arrays.asList("Gabe","Steve"), "Yeah its a no go tonight, I actually have a gig...");
        System.out.println();
        gabe.sendMessage(Arrays.asList("Riley", "Steve"), "Oh yeah... i forgot I gotta water my cat tonight, lets raincheck dinner night tho!");
        System.out.println();
        riley.sendMessage(Arrays.asList("Gabe"), "Yeah man fuck that guy, hes always trying to touch my arm at dinner, plus he smells like douche");
        System.out.println();
        gabe.sendMessage(Arrays.asList("Riley", "Steve"), "Yeah steven is big steaming pile of white garbage..");
        System.out.println();
        gabe.undoLastMessage();
        gabe.undoLastMessage();

        System.out.println("Iterating over messages sent by Gabe for Steve...\n");
        riley.iterateMessageHistoryByUser(gabe);


//        riley.sendMessage(Arrays.asList("Gabe","Steve"), "DUDE!");
//        System.out.println();
//        gabe.sendMessage(Arrays.asList("Riley", "Steve"), "Oh shit. Oh my bad I mean... ");
//        System.out.println();
//        steven.blockUser(gabe);
//
//        gabe.sendMessage(Arrays.asList("Steve"), "Hey man im super sorry");
//        gabe.sendMessage(Arrays.asList("Riley"), "Dude steve blocked me...");

    }
}