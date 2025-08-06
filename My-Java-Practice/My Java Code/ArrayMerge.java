import java.util.Arrays;

public class ArrayMerge{

    public static int[] merge(int[] a, int[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                merged[k] = a[i];
                k++;
                i++;
            } else if(a[i] > b[j]){
                merged[k] = b[j];
                k++;
                j++;
            }
        }
        if(i < a.length){
            while(i < a.length){
                merged[k] = a[i];
                k++;
                i++;
            }
        } else if(j < b.length){
            while(j < b.length){
                merged[k] = b[j];
                k++;
                j++;
            }
    }
    return merged;
}
    public static void main(String[] args){
        int[] a = {1,3,4,5,6,8,9};
        int[] b = {1,2,3,4};
        System.out.println(Arrays.toString(merge(a,b)));
    }
}