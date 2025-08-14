public class Edge{

    private Vertex startVertex;
    private Vertex endVertex;
    private int weight;
    public int flow;
    private Edge reverseEdge;

    public Edge(Vertex startVertex, Vertex endVertex, int weight){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
        this.flow = 0;
    }

    public boolean isResidual(){
        return this.weight <= 0;
    }

    public int remainingCapacity(){
        return this.weight - this.flow;
    }
    

    public int augment(int flow){
        if(flow > remainingCapacity()){
            throw new IllegalArgumentException("Flow exceeds remaning capacity");
        } else{
            this.flow += flow;
            this.reverseEdge.flow -= flow; //Update reverse edge flow
            if(this.flow < 0){
                throw new IllegalStateException("Flow cannot be negative");
            }
            return this.flow;
        }
    }
    //Account for reverse edge
    public void setReverseEdge(Edge reverseEdge){
        this.reverseEdge = reverseEdge;
        reverseEdge.reverseEdge = this; // Set the reverse edge's reverse to this edge
    }

    public Edge getReverseEdge(){
        return this.reverseEdge;
    }



    public Vertex getStartVertex(){
        return this.startVertex;
    }

    public Vertex getEndVertex(){
        return this.endVertex;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
}