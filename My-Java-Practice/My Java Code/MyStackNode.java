import java.util.ArrayList;

public class MyStackNode{
    
    private int top;
    private ArrayList<TreeNode> stack;

    public MyStackNode(){
        this.top = -1;
        this.stack = new ArrayList<>();

    }

    public boolean contains(TreeNode data){
        return stack.contains(data);
    }

    public int getTop(){
        return this.top;
    }

    public ArrayList<TreeNode> getStack(){
        return this.stack;
    }

    public boolean isEmpty(){
        return this.top < 0;
    }

    public void push(TreeNode item){
        this.stack.add(item);
        this.top++;

    }

    public TreeNode pop(){
        TreeNode poppedItem;
        if(this.top < 0){
            return null; //Stack is empty
        } else{
            poppedItem = this.stack.get(this.top);
            this.stack.remove(this.top);
                this.top--;
                
            }
            return poppedItem;

        }
    }
     