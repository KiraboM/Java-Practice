import java.util.ArrayList;

public class MyQueueJava{

    private int front;
    private int rear;
    private ArrayList<Integer> queue;
    private MyStack stack1;
    private MyStack stack2;

    public MyQueueJava(){
        this.front = -1;
        this.rear = -1;
        this.queue = new ArrayList<>();
        this.stack1 = new MyStack();
        this.stack2 = new MyStack();

    }

    public void enqueue(int item){
        this.stack1.push(item);
        if(this.front == -1){
            this.front = 0;
        }
        this.rear++;
    }

    public int dequeue(){
        if(this.front == -1 || this.front > this.rear){
            return -1; //Queue is empty
        } else{
            if(this.stack2.getTop() < 0){
                while(stack1.getTop() > -1){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    public void printQueue(){
        if(this.front == -1){
            System.out.println("Queue is empty");
        } else{
            ArrayList<Integer> temp = new ArrayList<>();
            while(this.stack2.getTop() >= 0){
                temp.add(this.stack2.pop());
            }
            for(Integer item : temp){
                System.out.print(item + ",");
            }
            while(temp.size() > 0){
                this.stack2.push(temp.remove(temp.size()-1));
            }
            while(stack1.getTop() >= 0){
                temp.add(this.stack2.pop());
            }
            for(Integer item : temp){
                System.out.print(item + ",");
            }
            while(temp.size() > 0){
                this.stack1.push(temp.remove(temp.size()-1));
            }
            
        }
    }

    public static void main(String[] args){
        MyQueueJava queue = new MyQueueJava();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(10);
        queue.enqueue(8);
        queue.enqueue(6);
        queue.dequeue();

        queue.printQueue();

    }

}