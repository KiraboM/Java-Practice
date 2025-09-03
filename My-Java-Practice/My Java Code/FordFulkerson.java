import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FordFulkerson{
        private Graph graph;
        private Vertex source;
        private Vertex sink;

        public FordFulkerson(Graph graph, Vertex source, Vertex sink){
            this.graph = graph;
            this.source = source;
            this.sink = sink;
        }

        //Helper method to find augmenting path from source to sink
        public Map<Vertex, Edge>findAugmentingPath(Graph graph, Vertex source, Vertex sink){
            //Use a BFS to find the augmenting path
            Map<Vertex, Edge> path = new HashMap<>();
            Queue<Vertex> queue = new LinkedList<>();
            queue.offer(source);
            path.put(source, null);
            while(!queue.isEmpty()){
                Vertex current = queue.poll();
                for(Edge e : current.getEdges()){
                    Vertex neighbor = e.getEndVertex();
                    if(!path.containsKey(neighbor) && e.getWeight() > 0){
                        path.put(neighbor, e);
                        queue.offer(neighbor);
                        if(neighbor == sink){
                            return path;
                        }
                    }
                }
            }
            return null; //No augmenting path found

        }

        public int getMaxFlow(){
            int maxFlow = 0;
            Map<Vertex, Edge> path = findAugmentingPath(this.graph, this.source, this.sink);
            while(path != null){
                int pathFlow = Integer.MAX_VALUE;
                Vertex v = this.sink;
                while(v != this.source){
                    Edge edge = path.get(v);
                    if(edge == null){
                        break; //No path found
                    }
                    pathFlow = Math.min(pathFlow, edge.getWeight());
                    v = edge.getStartVertex();
                }
                //Augment flow along the path and update the edges
                v = this.sink;
                while(v != this.source){
                    Edge edge = path.get(v);
                    if(edge == null){
                        break;
                    }

                    // Find or create the reverse edge for residual graph
                    Vertex u = edge.getStartVertex();
                    Vertex w = edge.getEndVertex();
                    Edge reverseEdge = null;
                    for (Edge rev : w.getEdges()) {
                        if (rev.getEndVertex() == u) {
                            reverseEdge = rev;
                            break;
                        }
                    }
                    if (reverseEdge == null) {
                        // If reverse edge does not exist, add it with zero initial capacity
                        reverseEdge = new Edge(w, u, 0);
                        graph.addEdge(w, u, 0);
                        edge.setReverseEdge(reverseEdge);
                    }
    
                     // Augment flow along the forward edge
                     // Update reverse edge's capacity
                    edge.augment(pathFlow);
                    reverseEdge.augment(pathFlow);

                    v = edge.getStartVertex();

                }
                maxFlow += pathFlow;
                path = findAugmentingPath(this.graph, this.source, this.sink);//Find next augmenting path
            }
            return maxFlow;
        }

        public static void main(String[] args){
            Graph graph = new Graph(true, true);
            Vertex v1 = graph.addVertex(1);
            Vertex v2 = graph.addVertex(2);
            Vertex v3 = graph.addVertex(3);
            Vertex v4 = graph.addVertex(4);
            Vertex v5 = graph.addVertex(5);
            Vertex v6 = graph.addVertex(6);
            Vertex v7 = graph.addVertex(7);
            Vertex v8 = graph.addVertex(8);
            graph.addEdge(v1, v2, 3);
            graph.addEdge(v2, v3, 5);
            graph.addEdge(v3, v1, 9);
            graph.addEdge(v3, v4, 2);
            graph.addEdge(v4, v5, 3);
            graph.addEdge(v5, v6, 12);
            graph.addEdge(v6, v7, 5);
            graph.addEdge(v7, v5, 7);
            graph.addEdge(v7, v8, 10);

            FordFulkerson fordFulkerson = new FordFulkerson(graph, v1, v8);
            System.out.println(fordFulkerson.getMaxFlow()); //Expected output: 10
        }



    }

    