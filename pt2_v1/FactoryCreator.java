package com.company;

import java.util.Locale;

/**
 * Singleton design pattern to enforce only one factory of each type at any given time
 */
public class FactoryCreator {
    private static FactoryCreator instance = null;

    private MacronutrientFactory carbFactory;
    private MacronutrientFactory proteinFactory;
    private MacronutrientFactory fatFactory;

    private FactoryCreator(){}

    // CarbsFactory.java
    public static class CarbsFactory extends MacronutrientFactory {
        private String dietPlan;
        public CarbsFactory(String dietPlan){
            this.dietPlan = dietPlan;
        }
        @Override
        public Macronutrient createMacronutrient() {
            return new Carb(dietPlan);
        }
    }

    // ProteinFactory.java
    public static class ProteinFactory extends MacronutrientFactory {
        @Override
        public Macronutrient createMacronutrient() {
            return new Protein();
        }
    }

    // FatsFactory.java
    public static class FatsFactory extends MacronutrientFactory {
        @Override
        public Macronutrient createMacronutrient() {
            return new Fat();
        }
    }

    // Singleton design pattern to enforce only one factory of each type at any given time
    public static FactoryCreator getInstance(){
        if(instance == null){
            instance = new FactoryCreator();
        }
        return instance;
    }

    public Macronutrient getMacronutrient(String type, String dietPlan){
        MacronutrientFactory factory = createFactory(type, dietPlan);
        Macronutrient macronutrient = factory.createMacronutrient();
        return macronutrient;
    }

    /** TODO: change this to get Macronutrient, or create Macronutrient Factory **/
    private MacronutrientFactory createFactory(String type, String dietPlan){
        //constructor
        type = type.toUpperCase(Locale.ROOT);
        switch(type){
            case "CARB":
                System.out.println("carb set");
                return new CarbsFactory(dietPlan);
            case "PROTEIN":
                System.out.println("protein set");
                return new ProteinFactory();
            case "FAT":
                System.out.println("fat set");
                return new FatsFactory();
        }
        /** TODO: Fix null return type **/
        System.out.println("ERROR, invalid macronutrient type!");
        System.exit(0);
        return null; // will never reach this line, will not return null instead exits program.
    }
}
