public abstract class CoffeeDecorator implements Coffee{

    private Coffee coffee;

    public CoffeeDecorator(Coffee newCoffee){

        this.coffee = newCoffee;

    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }


}
