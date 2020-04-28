public class arrayContainer implements itContainer {
    int[] arr = new int[]{1, 2, 3};

    @Override
    public iteratorInterface createIterator() {
        arrayIterator result = new arrayIterator();
        return result;
    }

    public class arrayIterator implements iteratorInterface {
        private int position;

        @Override
        public boolean hasNext() {
            if (position < arr.length)
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if (this.hasNext())
                return arr[position++];
            else
                return null;
        }
    }
}

