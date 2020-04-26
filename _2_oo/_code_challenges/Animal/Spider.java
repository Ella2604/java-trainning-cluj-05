public class Spider extends Animal {

    protected Spider() {
        super(8);

    }
    @Override
    void eat() {
        System.out.println("Spider can eat.");
        System.out.println("Every spider have " + legs + " legs.");
    }
}