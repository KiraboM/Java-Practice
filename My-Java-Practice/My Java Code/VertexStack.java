import java.util.ArrayList;

public class VertexStack{
    
    private int top;
    private ArrayList<Vertex> Stack;

    public VertexStack(){
        this.top = -1;
        this.Stack = new ArrayList<>();

    }

    public int getTop(){
        return this.top;
    }

    public void push(Vertex item){
        this.Stack.add(item);
        this.top++;

    }

    public boolean contains(Vertex item){
        return this.Stack.contains(item);
    }

    public Vertex pop(){
        Vertex poppedItem = this.Stack.get(this.top);
        this.Stack.remove(poppedItem);
        this.top--;
        return poppedItem;
    }

    public void printStack(){
        System.out.println(this.Stack);
    }
}