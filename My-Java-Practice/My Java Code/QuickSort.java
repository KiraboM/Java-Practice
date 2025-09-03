
import java.util.Arrays;

public class QuickSort{

    public void sort(int[] array, int left, int right){
        if(left < right){
            int pivot = partition(array, left, right);
            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
    }

    public int partition(int[] array, int left, int right){
        int pivot = array[right];
        int[] smaller = new int[array.length];
        int[] larger = new int[array.length];
        int small = 0;
        int large = 0;
        for(int i = 0; i < right; i++){
            if(array[i] < pivot){
                smaller[small] = array[i];
                small++;
            } else if(array[i] >= pivot){
                larger[large] = array[i];
                large++;
            }
        }
        for(int i = 0; i < small; i++){
            array[i + left] = smaller[i];
        }
        array[small + left] = pivot;
        for(int i = 0; i < large; i++){
            array[small + left + i + 1] = larger[i];
        }
        return small + left;
    }

    public static void main(String[] args) {
        int[] array = {3,1,6,7,3,5,8};
        QuickSort sorter = new QuickSort();
        sorter.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}