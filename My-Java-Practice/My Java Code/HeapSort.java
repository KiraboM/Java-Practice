import java.util.Arrays;

public class HeapSort{

    public int[] sort(int[] array){
        Heap heap = new Heap(array.length);
        for(int i = 0; i < array.length; i++){
            heap.add(array[i]);
        }
        for(int i = array.length - 1; i >= 0; i--){
            array[i] = heap.poll();
        }
        return array;
    }

    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();
        int[] array = {3,1,6,8,23,34,1,8,0};
        System.out.println(Arrays.toString(heapSort.sort(array)));
    }
}