public class Edge{

    private Vertex startVertex;
    private Vertex endVertex;
    private int weight;
    public int flow;

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
            return this.flow;
        }
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