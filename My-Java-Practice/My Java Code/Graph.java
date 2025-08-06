import java.util.ArrayList;
import java.util.List;

public class Graph{

    private List<Vertex> vertices;
    private List<Edge> edges;
    private boolean directed;
    private boolean weighted;

    public Graph(boolean directed, boolean weighted){
        this.directed = directed;
        this.weighted = weighted;
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Vertex getVertex(int data){
        for(Vertex vertex : vertices){
            if(vertex.getData() == data){
                return vertex;
            }
        }
        return null; //Vertex not found
    }

    public List<Vertex> getVertices(){
        return this.vertices;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }

    public Vertex addVertex(int data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(int data){
        vertices.removeIf(vertex -> vertex.getData() == data);
        edges.removeIf(edge -> edge.getStartVertex().getData() == data);
    }

    public void addEdge(Vertex startVertex, Vertex endVertex, int weight){
        if(!this.weighted){
            weight = 1; //Default weight for unweighted graphs
        }
        startVertex.addEdge(endVertex, weight);
        if(!this.directed){
            endVertex.addEdge(startVertex, weight);
        }
    }

    public void removeEdge(Vertex startVertex, Vertex endVertex){
        startVertex.removeEdge(endVertex);
        if(!this.directed){
            endVertex.removeEdge(startVertex);
        }
    }

    public boolean isDirected(){
        return this.directed;
    }

    public boolean isWeighted(){
        return this.weighted;
    }

    public static void main(String[] args) {

      
       
        }
    }
