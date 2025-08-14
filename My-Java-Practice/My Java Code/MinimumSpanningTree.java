import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class MinimumSpanningTree{

    public static int findMinimum(Graph graph, Vertex root){
        int totalCost = 0;
        int edgeCount = 0;
        PriorityQueue<QueueObjectEdge> priorityQueue = new PriorityQueue<>();
        List<Vertex> visited = new ArrayList<>();
        visited.add(root);
        for(Edge edge : root.getEdges()){
            priorityQueue.add(new QueueObjectEdge(edge, edge.getWeight()));
        }
        while(!priorityQueue.isEmpty() && edgeCount < graph.getVertices().size() - 1){
            QueueObjectEdge object = priorityQueue.poll();
            Edge edge = object.getEdge();
            if(edge == null) continue;
            Vertex vertex = edge.getEndVertex();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                totalCost += edge.getWeight();
                edgeCount++;
                for(Edge e : vertex.getEdges()){
                    if(!visited.contains(e.getEndVertex())){
                        priorityQueue.add(new QueueObjectEdge(e, e.getWeight()));
                    }
                }
            }
        }
        if(edgeCount == graph.getVertices().size() - 1){
            return totalCost;
        } else{
            return -1; //Graph has no spanning tree
        }
        }
        public static void main(String[] args) {
            
            Graph graph = new Graph(false, true);
            Vertex v1 = graph.addVertex(1);
            Vertex v2 = graph.addVertex(2);
            Vertex v3 = graph.addVertex(3);
    
            graph.addEdge(v1, v2, 5);
            graph.addEdge(v2, v3, 3);
            graph.addEdge(v1, v3, 7);
    
            MinimumSpanningTree mst = new MinimumSpanningTree();
            int cost = mst.findMinimum(graph, v1);
            System.out.println("MST Cost: " + cost);  // Expected: 8
}

        }
    
