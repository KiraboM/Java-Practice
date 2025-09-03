import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort{ 
    
    public int[] sort(Graph graph){
        int[] sortedList = new int[graph.getVertices().size()];//Used to store sorted vertices
        if(graph == null ||	graph.getVertices().isEmpty()){
            throw new IllegalArgumentException("Graph cannot be empty");
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new ArrayList<>();
        for(Vertex v : graph.getVertices()){
            if(!visited.contains(v.getData())){
                tdfs(graph, v.getData(), visited, stack);
                while(!stack.isEmpty()){
                    sortedList[index] = stack.pop();
                    index++;
                }
            }
        }
        return sortedList;
    }

    public void tdfs(Graph graph, int root, List<Integer> visited, Stack<Integer> stack){
        visited.add(root);
        Vertex current = graph.getVertex(root);
        for(Edge e : current.getEdges()){
            Vertex next = e.getEndVertex();
            if(!visited.contains(next.getData())){
                visited.add(next.getData());
                tdfs(graph, next.getData(), visited, stack);
            }
        }
        stack.push(root);//Push node after visiting all children
    }

    public static void main(String[] args) {
        Graph graph = new Graph(true, false);
        Vertex v1 = graph.addVertex(1);
        Vertex v2 = graph.addVertex(2);
        Vertex v3 = graph.addVertex(3);
        Vertex v4 = graph.addVertex(4);
        Vertex v5 = graph.addVertex(5);
        Vertex v6 = graph.addVertex(6);
        Vertex v7 = graph.addVertex(7);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v4, v5, 1);
        graph.addEdge(v4, v6, 1);
        graph.addEdge(v3, v7, 1);
        TopologicalSort sorter = new TopologicalSort();
        System.out.println(Arrays.toString(sorter.sort(graph))); //Expected output: [1,3,7,2,4,6,5]
    }
}