import java.util.ArrayList;
import java.util.List;

public class Kosaraju {

    protected MyStack numStack;

    public Kosaraju(){
        this.numStack = new MyStack();
    }
    
    public static void findSCC(Graph graph){

    }

    public List<Integer> Kdfs(Graph graph, int root){
        int t = 0;
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
                    int numVisited = 0;
                    for (Edge e : currentVertex.getEdges()) {
                        // Search every edge of the current vertex
                        Vertex nextVertex = e.getEndVertex();
                        if (!visited.contains(nextVertex.getData())) { // Check if the next vertex has already been visited
                            stack.push(nextVertex.getData());
                            visited.add(nextVertex.getData());//Add all visited vertexes to the visited list
                        } else{
                            numVisited++;
                        }
                    }
                    if(numVisited >= currentVertex.getEdges().size()){
                        this.numStack.push(currentVertex.getData());
                    }
                    
                }
            }
        }
        return visited;
    }
    
}
