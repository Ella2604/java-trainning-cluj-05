import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort implements SortingStrategy{

    private Integer[] merge(Integer[] left, Integer[]right) {
        Integer[] result = new Integer[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {

            if (leftPointer < left.length && rightPointer < right.length) {

                if (left[leftPointer] < right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            else if(leftPointer < left.length){
                result[resultPointer++] = left[leftPointer++];
            }

            else if(rightPointer < right.length){

                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

    @Override
    public Integer[] sort(Integer[] array) {

        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        Integer[] left = new Integer[midpoint];
        Integer[] right;

        if(array.length % 2 == 0){

            right = new Integer[midpoint];
        } else
        {
            right = new Integer[midpoint + 1];
        }
        for(int i=0; i < midpoint; i++){
            left[i] = array[i];
        }
        for(int j=0; j < right.length; j++){
            right[j] = array[midpoint + j];

        }
        left = sort(left);
        right = sort(right);

        array = merge(left, right);
        return array;
    }
}



