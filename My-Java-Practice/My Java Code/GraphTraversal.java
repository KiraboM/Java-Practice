import java.util.ArrayList;
import java.util.List;

public class GraphTraversal{

    public static List<Integer> dfs(Graph graph, int root){
        List<Integer> visited = new ArrayList<>();
        MyStack stack = new MyStack();
        stack.push(root);// Add first vertex onto the stack
        while(!stack.isEmpty()){
            int currentData = stack.pop();//Next visited vertex is the next vertex popped from the stack
            System.out.println(currentData);
            if (!visited.contains(currentData)) {
                visited.add(currentData);
                // Get the current vertex from the graph
                Vertex currentVertex = graph.getVertex(currentData);
                if (currentVertex != null) {
                    for (Edge e : currentVertex.getEdges()) {
                        // Search every edge of the current vertex
                        Vertex nextVertex = e.getEndVertex();
                        if (!visited.contains(nextVertex.getData())) { // Check if the next vertex has already been visited
                            stack.push(nextVertex.getData());
                            visited.add(nextVertex.getData());//Add all visited vertexes to the visited list
                        }
                    }
                }
            }
        }
        return visited; //Return list of visited vertices in the order they were visited
    }
}
