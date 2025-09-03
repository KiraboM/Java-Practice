import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra{

    public static HashMap<String, HashMap> dijkstra(Graph graph, Vertex root){
        HashMap<Integer, Integer> distances = new HashMap<>(); // Meant to store each vertex and its associated path from the root vertex
        HashMap<Integer, Vertex> previous = new HashMap<>();//Keeps track of all previous vertices visited

        PriorityQueue<QueueObject> queue = new PriorityQueue<>(); //Used to dertermine the next vertex visited
        queue.add(new QueueObject(root, 0));
        //Initialising the HashMap
        for(Vertex vertex : graph.getVertices()){
            if(!vertex.equals(root)){
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            }
            previous.put(vertex.getData(), null);
        }
        distances.put(root.getData(), 0);
        //Using a BFS to preform Dijkstra

        while(!queue.isEmpty()){
            Vertex current = queue.poll().getVertex();
            for(Edge edge : current.getEdges()){//Searching every edge of the current vertex
                int newDistance = distances.get(current.getData()) + edge.getWeight();
                Vertex neighbor = edge.getEndVertex();
                //If the calculated distance from the root vertex is less that the current distance assinged, the distance is updated
                if(newDistance < distances.get(neighbor.getData())){
                    distances.put(neighbor.getData(), newDistance);
                    previous.put(neighbor.getData(), current);
                    queue.add(new QueueObject(neighbor, newDistance));

                }
            }
        }
        HashMap<String, HashMap> results = new HashMap<>();
        results.put("distances", distances);
        results.put("previous", previous);
        //Return list of vertices with their shortest distances from the root vertex
        return results;
    }


}