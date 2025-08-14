
import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            int j = i;
            while(j > 0 && array[j - 1] > array[j]){
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        int[] array = {9,8,7,3,5,2,1,6};
        System.out.println(Arrays.toString(array));
        sorter.sort(array);
        System.out.println(Arrays.toString(array));

    }
    
}
