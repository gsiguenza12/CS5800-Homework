package com.company;
/**
 * Create a Macronutrient balanced meal for customer’s based on their given diet plans.
 * The system should generate a meal with one of the following at random:  Carbs, Protein
 * and Fats as long as it does not violate the customers diet plan.
 * Additionally, there should only be one factory of each type allocated at any given time
 * for the factories and one abstract factory to enforce this you will use the singleton
 * design pattern.
 */


// adapted from PrintSpooler source code
public class SingletonFactory {

    // we only want one object managing communication with a singleton resource
    private static SingletonFactory factoryManager = null;

    private SingletonFactory(){}

    // must have static variable, we will reference before it is instantiated
    public static SingletonFactory getInstance(){ // get instance is called meaning someone wants to use spooler at this time
        if (factoryManager == null)
            factoryManager = new SingletonFactory(); // only create one time and return that instance
        return factoryManager;
    }
}
