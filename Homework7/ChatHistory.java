package com.company;

import java.util.*;

/**
 * A class that stores the chat history for a user. It should have methods to add a new message to the history and
 * get the last message sent.
 */
public class ChatHistory implements IterableByUser{
    private Stack<MessageMemento> history = new Stack<>();
    private Map<MessageMemento, String> messageToUserMap = new HashMap<>();

    public void addMessage(MessageMemento memento, String recipients){
        history.push(memento);
        messageToUserMap.put(memento, recipients);
//        System.out.println("Added message to history: " + memento.getState() + " at " + memento.getState());
    }

    public MessageMemento getLastMessage(){
        if(!history.isEmpty()){
            MessageMemento memento = history.pop();
            messageToUserMap.remove(memento);
            return memento;
        }
        return null;
    }

    public void printHistory() {
        System.out.println("Chat History:");
        for (MessageMemento memento : history) {
            System.out.println("Message: " + memento.getState());
        }
    }

    @Override
    public Iterator<MessageMemento> iterator(User userToSearchWith){
        String userName = userToSearchWith.getName();
        return new ChatHistoryIterator(userName);
    }

    private class ChatHistoryIterator implements Iterator<MessageMemento> {
        private int index= 0;
        private List<MessageMemento> filteredMessages = new ArrayList<>();

        public ChatHistoryIterator(String userToSearchWith){
            System.out.println("ChatHistory Iterator called with userToSearchWith: " + userToSearchWith);
            // for debugging
//            System.out.println("Message to User Map: "+ messageToUserMap);

            for(MessageMemento memento : history){
                // for debugging
//                System.out.println("calling equals method on: " + messageToUserMap.get(memento) + " and " + userToSearchWith);
//                System.out.println(messageToUserMap.get(memento).equals(userToSearchWith));
                if (messageToUserMap.get(memento).equals(userToSearchWith)){
                    filteredMessages.add(memento);
                }
            }
        }

        @Override
        public boolean hasNext(){
            // for debugging
//            System.out.println("index: " + index + "\nfilteredMessages.size(): " + filteredMessages.size());
            return index < filteredMessages.size();
        }

        @Override
        public MessageMemento next(){
            // for debugging
//            System.out.println("Inside the next() method");
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return filteredMessages.get(index++);
        }
    }
}
