import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Recipe {
    // Create object as a HashMap in order to allow for dynamic updating due to varying quantities of ingredient variables
    public Map<String, Double> attributes = new HashMap<>();

    // Method to add new attribute
    public void addAttribute(String key, Double value) {
        attributes.put(key, value);
        
    }

    // Method to retrieve attribute value
    public Double getAttribute(String key) {
        return attributes.get(key);
    }

    // Method to adjust amount of ingredient based on multiple entered
    public double adjustIngredientAmount(double amount, double multiple) {
        amount = amount * multiple;
        return amount;
    }

    // Method to sort HashMap in a LinkedHashMap by key
    private Map<String, Double> getSortedAttributes() {
        return attributes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
                    ));
    }

    // Method to create List for entry set to iterate over and ensure sorted order is maintained
    public List<Map.Entry<String, Double>> sortAttributes() {
        return new ArrayList<>(getSortedAttributes().entrySet());

    }



    /* 
           Map<String, Double> sortedMap = recipe.attributes.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
        (e1, e2) -> e1, LinkedHashMap::new));
        
        StringBuilder output = new StringBuilder();

        sortedMap.forEach((key, value) -> output.append(key).append(" ").append(value).append("\n"));
                             */

    // Initialize sortedEntries List to be used as iterable object
    public String generateSortedOutput() {
        List<Map.Entry<String, Double>> sortedEntries = sortAttributes();

        // StringBuilder to store cleaned, sorted List
        StringBuilder output = new StringBuilder();

        // Iterate over List and clean up lines for ease of reading
        for (Map.Entry<String, Double> entry : sortedEntries) {
            output.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        return output.toString();
    }

    // FIX NEEDED: Is currently bypassed lol....
    // Display all attributes for debugging
    @Override
    public String toString() {           
        return "Amount of product used:  " + generateSortedOutput();
    }


}
