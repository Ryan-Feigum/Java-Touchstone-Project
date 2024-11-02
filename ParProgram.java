import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ParProgram {
    public static void main(String[] args) {
        // Set global local variables
        String recipeName;
        String anotherOne = "yes";
        double multiple = 1;
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        Recipe recipe = new Recipe();

        // Loop to keep adding recipes until user decides to end program
        while (anotherOne.equalsIgnoreCase("yes")) {
            // Create new recipe object from Recipe.java class
            

            // Prompt 1 to request which recipe to pull information from
            System.out.println("Which recipe was prepped?");
            // Read user input and store in recipeName variable
            recipeName = scanner.nextLine().toLowerCase();

            // Prompt 2 to request the multiple of the recipe prepped
            System.out.println("How many times was the recipe prepped?");
            // Read user input and store in multiple variable
            multiple = scanner.nextInt();

            // Consumes leftover new line left over from  scanner.nextInt()
            scanner.nextLine();

            // Try catch to handle file not found exception
            try (BufferedReader br = new BufferedReader(new FileReader(recipeName + ".txt"))) {
                String line;
                // Read file line by line
                while ((line = br.readLine()) != null) {
                    // Split key:value pairs into individual variables
                    String[] parts = line.split(":", 2);
                    if (parts.length < 2) continue; 

                    // Set key as ingredientName variable
                    String ingredientName = parts[0].trim();

                    // Set value as ingredientQuantity
                    double ingredientQuantity = Double.parseDouble(parts[1].trim());

                    // Update value of ingredientQuantity by multiplying by multiple
                    double updatedQuantity = recipe.adjustIngredientAmount(ingredientQuantity, multiple);

                    // Update value if key exists. Otherwise add key:value
                    if(recipe.attributes.containsKey(ingredientName)) {
                        double formerQuantity = recipe.attributes.get(ingredientName);
                        recipe.addAttribute(ingredientName, formerQuantity + updatedQuantity);
                    } else {
                        recipe.addAttribute(ingredientName, updatedQuantity);
                    }
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            

            // Debugging to ensure attributes are being properly manipulated and assigned
            System.out.println(recipe.toString());

            // Write to new file with prepMultiple appended to the end of the filename


            // Prompt 3 to determine whether to break the loop
            System.out.println("Do you want to add another recipe?");
            // Read user input and store in anotherOne variable
            anotherOne = scanner.nextLine().toLowerCase();

        }
        // Close scanner to prevent resource leaks
        scanner.close();
    }
}