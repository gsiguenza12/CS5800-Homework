package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The Carbs, Protein and Fats should all be built each using the Factory Design Patterns
 * Fish, Chicken, Beef, Tofu
 */
public class Protein extends Macronutrient {

    private static final List<String> PROTEIN_OPTIONS = Arrays.asList("Fish", "Chicken", "Beef", "Tofu");
    private static final List<String> PALEO_PROTEINS = Arrays.asList("Fish", "Chicken", "Beef");
    private static final List<String> VEGAN_PROTEINS = Arrays.asList("Tofu");
    private static final List<String> NUT_ALLERGY_PROTEINS = PROTEIN_OPTIONS;
    private String dietPlan;

    public Protein(String dietPlan) { this.dietPlan = dietPlan; }

    @Override
    public String produce() {
        List<String> options;
        switch (dietPlan) {
            case "Paleo":
                options = PALEO_PROTEINS;
                break;
            case "Vegan":
                options = VEGAN_PROTEINS;
                break;
            case "Nut Allergy":
                options = NUT_ALLERGY_PROTEINS;
                break;
            default:
                options = PROTEIN_OPTIONS;
                break;
        }
        return options.get(new Random().nextInt(options.size()));
    }
}