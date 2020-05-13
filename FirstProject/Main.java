import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();

        System.out.println(coffee.getDescription() + " = " + coffee.getCost());
        System.out.println("Ingredients: ");
        System.out.println("Ingredient 1: Sugar, Price 0.5");
        System.out.println("Ingredient 2: Milk, Price 0.9");
        System.out.println("Ingredient 3: Cream, Price 0.8");

        boolean selectIngredient = true;
        while(selectIngredient ) {
            System.out.println("Enter the name of ingredient or something else to stop.");
            Scanner scanner = new Scanner(System.in);
            String ingredient = scanner.nextLine();

            coffee = CoffeeFactory.getNewCoffee(ingredient, coffee);
            if(coffee == null){
                selectIngredient = false;
            }
            else{
            System.out.println(coffee.getDescription() + " = " + coffee.getCost());
            }
        }
    }

}
