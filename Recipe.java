import java.util.HashMap;
import java.util.Map;


public class Recipe {
    private Map<String, Object> attributes = new HashMap<>();

    // Method to add new attribute
    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    // Method to retrieve attribute value
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    // Method to adjust amount of ingredient based on multiple entered
    public float adjustIngredientAmount(float amount, float multiple) {
        amount = amount * multiple;
        return amount;
    }

    // Display all attributes
    @Override
    public String toString() {
        return "Attributes:  " + attributes;
    }


}
