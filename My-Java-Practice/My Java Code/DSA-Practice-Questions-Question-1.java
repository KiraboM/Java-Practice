public void rotateArray(int[] nums, int k){
    int numAdded = 0;
    int i = 0 + k;
    int[] temp = new int[nums.length];
    while(numAdded < nums.length){
        temp[i] = nums[numAdded];
        numAdded++;
        i++;
        if(i >= nums.length){
            i = 0;
        }
    }
    for(int n = 0; n < nums.length; n++){
        nums[n] = temp[n];
    }
}

public static void main(String[] args){
    int[] nums = {1,2,3,4,5,6,7,8,9};
    rotateArray(nums, 6);
    System.out.println(nums.toString());
}