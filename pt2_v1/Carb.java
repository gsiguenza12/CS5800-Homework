    package com.company;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Random;

    /**
     * The Carbs, Protein and Fats should all be built each using the Factory Design Patterns
     * cheese, bread, lentils, pistachio
     */
    public class Carb extends Macronutrient{
        private static final List<String> CARBS_OPTIONS = Arrays.asList("Cheese", "Bread", "Lentils", "Pistachio");
        private static final List<String> PALEO_CARBS = Arrays.asList("Pistachio");
        private static final List<String> VEGAN_CARBS = Arrays.asList("Bread", "Lentils", "Pistachios");
        private static final List<String> NUT_ALLERGY_CARBS = Arrays.asList("Cheese", "Bread", "Lentils");
        private String dietPlan;

        public Carb(String dietPlan) { this.dietPlan = dietPlan; }
//        public void setDietPlan(String dietPlan){
//            this.dietPlan = dietPlan;
//        }

        @Override
        public String produce() {
            List<String> options;
            switch (dietPlan) {
                case "Paleo":
                    options = PALEO_CARBS;
                    break;
                case "Vegan":
                    options = VEGAN_CARBS;
                    break;
                case "Nut Allergy":
                    options = NUT_ALLERGY_CARBS;
                    break;
                default:
                    options = CARBS_OPTIONS;
                    break;
            }
            return options.get(new Random().nextInt(options.size()));
        }
    }
