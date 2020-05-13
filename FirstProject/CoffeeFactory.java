public class CoffeeFactory {

    public static Coffee getNewCoffee(String ingredient, Coffee currentCoffee){
         if(ingredient.equals("Sugar")){
             return new SugarCoffee(currentCoffee);
         }
        if(ingredient.equals("Milk")){
            return new MilkCoffee(currentCoffee);
        }
        if(ingredient.equals("Cream")){
            return new CreamCoffee(currentCoffee);
        }
        return null;
    }
}
