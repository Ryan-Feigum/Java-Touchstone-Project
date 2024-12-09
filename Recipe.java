import java.util.HashMap;
import java.util.Map;


public class Recipe {
    // Create object as a HashMap in order to allow for dynamic updating due to varying quantities of ingredient variables
    public Map<String, Double> attributes = new HashMap<>();

    // Method to add new attribute
    public void addAttribute(String key, Double value) {
        attributes.put(key, value);
        
    }

    // Method to retrieve attribute value
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    // Method to adjust amount of ingredient based on multiple entered
    public double adjustIngredientAmount(double amount, double multiple) {
        amount = amount * multiple;
        return amount;
    }

    // Display all attributes for debugging
    @Override
    public String toString() {
        return "Amount of product used:  " + attributes;
    }


}
