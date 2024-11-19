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
        System.out.println("Added message to history: " + memento.getState() + " at " + memento.getState());
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

            System.out.println("Message to User Map: "+ messageToUserMap);

            for(MessageMemento memento : history){
                System.out.println("calling equals method on: " + messageToUserMap.get(memento) + " and " + userToSearchWith);
                System.out.println(messageToUserMap.get(memento).equals(userToSearchWith));
                if (messageToUserMap.get(memento).equals(userToSearchWith)){
                    filteredMessages.add(memento);
                }
            }
        }
//        private User userToSearchWith;

//        public ChatHistoryIterator(User userToSearchWith){
//            this.userToSearchWith = userToSearchWith;
//            this.index = 0;
//        }

        @Override
        public boolean hasNext(){
            System.out.println("index: " + index + "\nfilteredMessages.size(): " + filteredMessages.size());
            return index < filteredMessages.size();
//            while(index < history.size()){
//                System.out.println("Inside the hasNext() method");
//                MessageMemento memento = history.get(index);
//                System.out.println(memento.getState());
//                User associatedUser = messageToUserMap.get(memento);
//                if(associatedUser!=null && associatedUser.equals(userToSearchWith)){
//                    System.out.println("return true!");
//                    return true;
//                }
//                index++;
//            }
//            System.out.println("return false!");
//            return false;
        }

        @Override
        public MessageMemento next(){
            System.out.println("Inside the next() method");
            if(!hasNext()){
                throw new NoSuchElementException();
            }
//            return history.get(index++);
            return filteredMessages.get(index++);
        }
    }
}
