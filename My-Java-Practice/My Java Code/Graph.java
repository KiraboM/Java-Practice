import java.util.ArrayList;
import java.util.HashMap;
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

        Graph graph = new Graph(true, true);
        Vertex v1 = graph.addVertex(1);
        Vertex v2 = graph.addVertex(2);
        Vertex v3 = graph.addVertex(3);
        Vertex v4 = graph.addVertex(4);
        Vertex v5 = graph.addVertex(5);
        Vertex v6 = graph.addVertex(6);
        Vertex v7 = graph.addVertex(7);
        graph.addEdge(v1, v2, 3);
        graph.addEdge(v1, v3, 6);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v3, v5, 7);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v5, v6, 2);
        graph.addEdge(v6, v7, 3);
        graph.addEdge(v3, v7, 10);
        HashMap<String, HashMap> results = Dijkstra.dijkstra(graph, v1);
        results.get("distances").forEach((key, value) ->{
            System.out.println("Vertex: " + key + " Distance from root node: " + value);
        });

      
       
        }
    
    }
