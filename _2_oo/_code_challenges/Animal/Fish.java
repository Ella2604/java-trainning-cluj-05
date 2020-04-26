public class Fish extends Animal{
    public Fish() {
        super(0);

    }

    @Override
    void eat() {
        System.out.println("The fish can eat.");
    }
    @Override
    public void walk(){
        System.out.println("The fish can`t walk because the fish don`t have legs.");

    }
}