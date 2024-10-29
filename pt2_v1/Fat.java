package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The Carbs, Protein and Fats should all be built each using the Factory Design Patterns
 * Avocado, Sour Cream, Tuna, Peanuts
 */
public class Fat extends Macronutrient {

    private static final List<String> FATS_OPTIONS = Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts");
    private static final List<String> PALEO_FATS = Arrays.asList("Avocado", "Tuna", "Peanuts");
    private static final List<String> VEGAN_FATS = Arrays.asList("Avocado", "Peanuts");
    private static final List<String> NUT_ALLERGY_FATS = Arrays.asList("Avocado", "Sour cream", "Tuna");
    private String dietPlan;

    public Fat(String dietPlan) { this.dietPlan = dietPlan; }

    @Override
    public String produce() {
        List<String> options;
        switch (dietPlan) {
            case "Paleo":
                options = PALEO_FATS;
                break;
            case "Vegan":
                options = VEGAN_FATS;
                break;
            case "Nut Allergy":
                options = NUT_ALLERGY_FATS;
                break;
            default:
                options = FATS_OPTIONS;
                break;
        }
        return options.get(new Random().nextInt(options.size()));
    }
}
