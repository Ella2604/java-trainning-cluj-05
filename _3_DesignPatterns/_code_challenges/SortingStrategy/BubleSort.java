public class BubleSort implements SortingStrategy{
    @Override
    public Integer[] sort(Integer[] array) {
        boolean isOrdered = false;

        while(!isOrdered){
            isOrdered = true;
            for(int i=0; array.length - 1 > i; i++){

                if(array[i] > array[i+1]){

                    swap(array, i, i+1);
                    isOrdered = false;
                }

            }

        }
        return array;
    }

    private void swap(Integer[] array, int i, int i1) {

        int aux = array[i];
        array[i] = array[i+1];
        array[i+1] = aux;
    }
}
