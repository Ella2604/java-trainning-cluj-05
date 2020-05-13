public class BasicCoffee implements Coffee{
    @Override
    public String getDescription() {
       return "Simple coffee";
    }

    @Override
    public double getCost() {
    return 3.5;
    }
}
