public class QueueObjectEdge implements Comparable<QueueObjectEdge>{
    private Edge edge;
    private int priority;

    public QueueObjectEdge(Edge edge, int priority){
        this.edge = edge;
        this.priority = priority;
    }

    public Edge getEdge(){
        return this.edge;
    }

    public int getPriority(){
        return this.priority;
    }

    public int compareTo(QueueObjectEdge object){
        if(this.priority == object.getPriority()){
            return 0;
        } else if(this.priority < object.getPriority()){
            return -1;
        } else{
            return 1;
        }
    }


}