import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra{

    public static HashMap[] dijkstra(Graph graph, Vertex root){
        HashMap<String, Integer> distances = new HashMap<>();
        HashMap<String, Vertex> previous = new HashMap<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();
        ArrayList<Vertex> visited = new ArrayList<>();
        queue.add(new QueueObject(root, 0));

        for(Vertex vertex : graph.getVertices()){
            if(!vertex.equals(root)){
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            }
            previous.put(vertex.getData(), null);
        }
        distances.put(root.getData(), 0);
        visited.add(root);

        while(!queue.isEmpty()){
            Vertex current = queue.poll().getVertex();
            for(Edge edge : current.getEdges()){
                int newDistance = distances.get(current.getData()) + edge.getWeight();
                Vertex neighbor = edge.getEndVertex();
                if(newDistance < distances.get(neighbor.getData())){
                    distances.put(neighbor.getData(), newDistance);
                    previous.put(neighbor.getData(), current);
                    if(!visited.contains(neighbor)){
                        queue.add(new QueueObject(neighbor, newDistance));
                        visited.add(neighbor);
                    }
                }
            }
        }
        
        return new HashMap[]{distances, previous};
    }


}