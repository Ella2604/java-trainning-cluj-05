public class CreamCoffee extends CoffeeDecorator{
    public CreamCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.8;
    }

}
