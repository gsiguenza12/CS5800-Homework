package com.company;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryCreatorTest {

    @Test
    public void testGetInstance() {
        FactoryCreator instance1 = FactoryCreator.getInstance();
        FactoryCreator instance2 = FactoryCreator.getInstance();
        assertNotNull(instance1);
        assertSame("FactoryCreator should return the same instance", instance1, instance2);
    }

    @Test
    public void testCreateFactoryCarb() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        MacronutrientFactory carbFactory = factoryCreator.createFactory("CARB", "Paleo");
        assertTrue("Factory should create CarbsFactory", carbFactory instanceof FactoryCreator.CarbsFactory);
    }

    @Test
    public void testCreateFactoryProtein() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        MacronutrientFactory proteinFactory = factoryCreator.createFactory("PROTEIN", "Vegan");
        assertTrue("Factory should create ProteinFactory", proteinFactory instanceof FactoryCreator.ProteinFactory);
    }

    @Test
    public void testCreateFactoryFat() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        MacronutrientFactory fatFactory = factoryCreator.createFactory("FAT", "Nut Allergy");
        assertTrue("Factory should create FatsFactory", fatFactory instanceof FactoryCreator.FatsFactory);
    }

    @Test
    public void testGetMacronutrientCarb() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        Macronutrient carb = factoryCreator.getMacronutrient("CARB", "Paleo");
        assertTrue("Factory should return an instance of Carb", carb instanceof Carb);
    }

    @Test
    public void testGetMacronutrientProtein() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        Macronutrient protein = factoryCreator.getMacronutrient("PROTEIN", "Vegan");
        assertTrue("Factory should return an instance of Protein", protein instanceof Protein);
    }

    @Test
    public void testGetMacronutrientFat() {
        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        Macronutrient fat = factoryCreator.getMacronutrient("FAT", "Nut Allergy");
        assertTrue("Factory should return an instance of Fat", fat instanceof Fat);
    }
}

