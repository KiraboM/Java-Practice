import java.util.ArrayList;
import java.util.List;

public class Duplicates{


    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> duplicates = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            // Checking if each number is already visited
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
            } else{
                // If the number is already visited, add it to duplicates
                if(!duplicates.contains(nums[i])){
                    duplicates.add(nums[i]);
                }
            }
        }
        // Returning the list of duplicates
        return duplicates;
    }
    public static void main(String[] args){
        int[] nums = {4,3,4,5,6,3,8,6,9};
        System.out.println(findDuplicates(nums));
    }
    //This function has a time complexity of O(n) as the the loop iterates through the array once
    //This function has a space complexity of O(n) as I add two lists to store numbers in

}
