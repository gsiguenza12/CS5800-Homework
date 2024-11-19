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

            for(MessageMemento memento : history){
                if (messageToUserMap.get(memento).equals(userToSearchWith)){
                    filteredMessages.add(memento);
                }
            }
        }

        @Override
        public boolean hasNext(){
            return index < filteredMessages.size();
        }

        @Override
        public MessageMemento next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return filteredMessages.get(index++);
        }
    }
}
