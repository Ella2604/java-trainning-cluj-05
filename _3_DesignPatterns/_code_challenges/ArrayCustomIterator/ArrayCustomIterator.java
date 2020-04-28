import java.util.Iterator;

public class ArrayCustomIterator {
    public static void main(String[] args) {

        itContainer itContainer = new arrayContainer();
        iteratorInterface iteratorInterface = itContainer.createIterator();
        while (iteratorInterface.hasNext()) {
            Object object = iteratorInterface.next();
            System.out.println(object);
        }
    }
}
