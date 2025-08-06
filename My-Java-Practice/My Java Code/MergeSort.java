
public class MergeSort{
    
    public void mergeSort(int[] array){
        if(array.length < 2){
            return; //Array is already sorted
        } else{
            int mid = array.length/2;
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];
            for(int i = 0; i < mid; i++){
                left[i] = array[i];
            }
            for(int i = mid; i < array.length; i++){
                right[i - mid] = array[i];
                
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public void merge(int[] array, int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i]< right[j]){
                array[k] = left[i];
                i++;
                k++;
            } else if(left[i] > right[j]){
                array[k] = right[j];
                j++;
                k++;
            } else if(left[i] == right[j]){
                array[k] = left[i];
                right[j] = -100; // right[j] has been removed from the array
                left[i] = -100;
                k++;
                i++;
                j++;

            }
        }
        if(i < left.length){
            while(i < left.length){
                if(left[i] != -100){
                    array[k] = left[i];
                }
                i++;
                k++;
            }
        } else if(j < right.length){
            while(j < right.length){
                if(right[j] != -100){
                    array[k] = right[j];
                }
                j++;
                k++;
        }
    }
}
  public static void main(String[] args){
      MergeSort sorter = new MergeSort();
      int[] array = {1,9,3,1,5,5,9,3,6};
      System.out.println("Array before sorting:");
      for(int i = 0; i < array.length; i++){
        System.out.print(array[i] + " , ");
      }
      sorter.mergeSort(array);
      System.out.println("Array after sorting:");
      for(int i = 0; i < array.length; i++){
        System.out.print(array[i] + " , ");
      }
  }
} 