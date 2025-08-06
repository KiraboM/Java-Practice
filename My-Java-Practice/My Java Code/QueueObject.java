

public class QueueObject implements Comparable<QueueObject>{
    private Vertex vertex;
    private int priority;

    public QueueObject(Vertex vertex, int priority){
        this.vertex = vertex;
        this.priority = priority;
    }

    public Vertex getVertex(){
        return this.vertex;
    }

    public int getPriority(){
        return this.priority;
    }

    public int compareTo(QueueObject object){
        if(this.priority == object.getPriority()){
            return 0;
        } else if(this.priority < object.getPriority()){
            return -1;
        } else{
            return 1;
        }
    }


}