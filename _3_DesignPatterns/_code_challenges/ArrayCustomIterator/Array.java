import java.util.ArrayList;
import java.util.List;

class Array implements itContainer {
    private List<Integer> it = new ArrayList();

    public Array() {
        it.add(1);
        it.add(2);
        it.add(3);
    }

    public iteratorInterface createIterator() {
        arrIterator result = new arrIterator();
        return result;
    }

    public class arrIterator implements iteratorInterface {

        @Override
        public boolean hasNext() {
            if (it.size() > 0)
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                int i = it.get(0);
                it.remove(0);
                return i;
            } else
                return null;
        }
    }
}
