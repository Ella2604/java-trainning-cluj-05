public class SugarCoffee extends CoffeeDecorator{

    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
