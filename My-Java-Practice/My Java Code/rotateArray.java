public class rotateArray{
    public static void rotate(int[] nums, int k){
    int j = nums.length - 1;
    int i = 0;
    //First I reverse the entire array
    while(i < j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
    j = k - 1;
    i = 0;
    //Then I reverse the first k elements
    while(i < j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
    //Finally I reverse the rest of the array
    j = nums.length - 1;
    i = k;
    while(i < j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
}
 public static void main(String[] args){
    int[] nums = {1,2,3,4,5,6,7,8,9};
    rotate(nums, 6);
    for (int i = 0; i < nums.length; i++){
        System.out.print(nums[i] + " ");
    }
    }
}

//This function has a time complexity of O(n) as it loops through the array three times
//This function has a space complexity of O(1) as no new arrays are added

