import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy010fArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy020fArr = Arrays.copyOf(arr, arr.length);

        displaySorted(new BubleSort(), copy010fArr);
        displaySorted(new MergeSort(), copy020fArr);


    }

    public static void displayArray(Integer[] array) {
        for (int i = 0; array.length > i; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println();
    }

    private static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        arr = strategy.sort(arr);

        displayArray(arr);


    }

}



