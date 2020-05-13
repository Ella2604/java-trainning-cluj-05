public class MilkCoffee extends CoffeeDecorator{

    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.9;
    }
}
