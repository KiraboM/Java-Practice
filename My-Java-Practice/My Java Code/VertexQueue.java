
public class VertexQueue{

    private int front;
    private int rear;
    private VertexStack stack1;
    private VertexStack stack2;

    public VertexQueue(){
        this.front = -1;
        this.rear = -1;
        this.stack1 = new VertexStack();
        this.stack2 = new VertexStack();

    }

    public boolean isEmpty(){
        return this.front < 0;
    }

    public boolean contains(Vertex item){
        return this.stack1.contains(item) || this.stack2.contains(item);
    }

    public void enqueue(Vertex item){
        this.stack1.push(item);
        if(this.front == -1){
            this.front = 0;
        }
        this.rear++;
    }

    public Vertex dequeue(){
        if(this.front == -1 || this.front > this.rear){
            return null; //Queue is empty
        } else{
            if(this.stack2.getTop() < 0){
                while(stack1.getTop() > -1){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    

}