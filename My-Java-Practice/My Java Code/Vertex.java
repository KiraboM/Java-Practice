import java.util.ArrayList;
import java.util.List;

public class Vertex{

    private int data;
    private List<Edge> edges;

    public Vertex(int data){
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public void addEdge(Vertex vertex, int weight){
        Edge newEdge = new Edge(this, vertex, weight);
        this.edges.add(newEdge);
    }

    public void removeEdge(Vertex vertex){
        edges.removeIf(edge -> edge.getEndVertex().equals(vertex));
    }

    public List<Edge> getEdges(){
        return this.edges;
    }
}