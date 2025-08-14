public class KthLargest{

    private int k;
    private Heap heap;
    private int[] nums;

    public KthLargest(int k, int[] nums){
        this.k = k;
        this.nums = nums;
        this.heap = new Heap(100);
        for (int i = 0; i < nums.length; i++){
            this.heap.add(nums[i]);
        }
    }

    public int add(int val){
        int[] list = new int[this.k];
        this.heap.add(val);
        for(int i = 0; i < this.k; i++){
            list[i] = this.heap.poll();
        }
        int returnNum = list[k - 1];
        for(int i = 0; i < this.k; i++){
            this.heap.add(list[i]);
        }
        return returnNum;
    } 

    public static void main(String[] args){
        int[] nums = {4,5,8,2};
        KthLargest KthLargest = new KthLargest(3, nums);
        System.out.println(KthLargest.add(3));
        System.out.println(KthLargest.add(5));
        System.out.println(KthLargest.add(10));
        System.out.println(KthLargest.add(9));
        System.out.println(KthLargest.add(4));
    }
}