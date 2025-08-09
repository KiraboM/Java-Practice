import java.util.ArrayList;

public class MyStack{
    
    private int top;
    private ArrayList<Integer> stack;
    private int min;
    private ArrayList<Integer> minValues;

    public MyStack(){
        this.top = -1;
        this.stack = new ArrayList<>();
        this.min = Integer.MAX_VALUE;
        this.minValues = new ArrayList<>();

    }

    public boolean contains(int data){
        return stack.contains(data);
    }

    public int getTop(){
        return this.top;
    }

    public ArrayList<Integer> getStack(){
        return this.stack;
    }

    public boolean isEmpty(){
        return this.top < 0;
    }

    public void push(int item){
        this.stack.add(item);
        if(item <= this.min){
            this.min = item;
            this.minValues.add(item);
        }
        this.top++;

    }

    public int pop(){
        if(this.top < 0){
            return -1; //Stack is empty
        } else{
            int poppedItem = this.stack.get(this.top);
            this.stack.remove(this.top);
            if(poppedItem == this.min){
                this.minValues.remove(this.minValues.size() - 1);
                if(this.minValues.isEmpty()){
                    this.min = Integer.MAX_VALUE;
                } else{
                    this.min = this.minValues.get(this.minValues.size() - 1);
                }
                }
                this.top--;
                return poppedItem;
            }

        }
     

   public int minElement(){
        if(this.isEmpty()){
            return -1; // Stack is empty
        } else{
            //Return the minimum element
            int item  = this.minValues.get(this.minValues.size() - 1);
            return item;
            // This function has a time complexity of O(1) as it returns that last element of the minValues list
            // This function has a space complexity of O(n) as it uses an additional list to store minimum values


        }
        }
    



    public void printStack(){
        System.out.println(this.stack);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(6);
        stack.push(8);
        stack.push(4);
        stack.push(3);
        stack.push(9);
        stack.push(1);
        int i = stack.pop();
        stack.push(12);
        System.out.println(stack.getStack());
        System.out.println("Minimum element: " + stack.minElement() );
    }

}