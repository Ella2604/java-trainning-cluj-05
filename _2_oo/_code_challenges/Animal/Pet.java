public interface Pet {
    String getName();
    void setName(String name);
    void play();
}
public class Cat extends Animal implements Pet {
    String name;

    public Cat(String name) {
        super(4);
        this.name = name;

    }