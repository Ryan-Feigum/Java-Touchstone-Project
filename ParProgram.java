import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ParProgram {
    public static void main(String[] args) {
        String recipeName;
        String anotherOne = "yes";
        float multiple = 1;
        Scanner scanner = new Scanner(System.in);


        // Loop to keep adding recipes until user decides to end program
        while (anotherOne == "yes") {
            Recipe recipe = new Recipe();
            

            // Prompt 1 to determine which recipe to pull information from
            System.out.println("Which recipe was prepped?");
            recipeName = scanner.nextLine().toLowerCase();

            // Prompt 2 to determine the multiple of the recipe prepped
            System.out.println("How many times was the recipe prepped?");
            multiple = scanner.nextInt();

            try (BufferedReader br = new BufferedReader(new FileReader(recipeName + ".txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if  (parts.length < 2) continue; 

                    String ingredientName = parts[0].trim();

                    recipe.addAttribute(ingredientName, recipe.adjustIngredientAmount(Integer.parseInt(parts[1].trim()), multiple));

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println(recipe.toString());

            // Prompt 3 to determine whether to break the loop
            System.out.println("Do you want to add another recipe?");
            anotherOne = scanner.nextLine().toLowerCase();

        }
    }
}