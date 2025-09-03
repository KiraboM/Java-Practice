import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kosaraju {
    
    public static List<List<Integer>> findSCC(Graph graph, int root){

        MyStack stack = Kdfs(graph, root);
        //Use the stack to find the strongly connected components
        List<List<Integer>> sccList = new ArrayList<>();// Store a list of the scc's found
        Set<Integer> visited = new HashSet<>();
        Graph transposedGraph = transposeGraph(graph);//Transpose the given graph
        while(!stack.isEmpty()){
            int currentData = stack.pop();//Remove the next vertex from the stack
            //If the current vertex has not been visited, preform a DFS search to find the next strongly connected component
            if(!visited.contains(currentData)){
                List<Integer> scc = new ArrayList<>();
                dfsVisit(transposedGraph, currentData, visited, scc);
                if(!scc.isEmpty()){
                    sccList.add(scc);//Add the found scc to the list
                }
            }
        }
        return sccList; //Return the list of strongly connected components
        
    }

    public static void dfsVisit(Graph graph, int vertex, Set<Integer> visited, List<Integer> scc){
        visited.add(vertex);
        scc.add(vertex);
        Vertex currentVertex = graph.getVertex(vertex);
        if(currentVertex != null){
            for(Edge e : currentVertex.getEdges()){
                Vertex nextVertex = e.getEndVertex();
                if(!visited.contains(nextVertex.getData())){
                    dfsVisit(graph, nextVertex.getData(), visited, scc);
                }
            }
        }
    }

    public static MyStack Kdfs(Graph graph, int root) {
    Set<Integer> visited = new HashSet<>();
    MyStack returnStack = new MyStack();
    for(Vertex v : graph.getVertices()){
        if(!visited.contains(v.getData())){
            dfsFirst(graph, v.getData(), visited, returnStack);
        }
    }
    return returnStack;
}

private static void dfsFirst(Graph graph, int vertex, Set<Integer> visited, MyStack stack) {
    visited.add(vertex);
    Vertex current = graph.getVertex(vertex);
    if (current != null) {
        for (Edge e : current.getEdges()) {
            int nextData = e.getEndVertex().getData();
            if (!visited.contains(nextData)) {
                dfsFirst(graph, nextData, visited, stack);
            }
        }
    }
    stack.push(vertex);
}
    public static Graph transposeGraph(Graph graph){
        Graph transposedGraph = new Graph(graph.isDirected(), graph.isWeighted());
        //Create a new graph to hold the transposed graph
        //Iterate through the original graph and reverse the edges
        for(Vertex v : graph.getVertices()){
            transposedGraph.addVertex(v.getData());
        }
        //Reverse all edges
        for(Vertex v : graph.getVertices()){
            for(Edge e : v.getEdges()){
                Vertex fromVertex = transposedGraph.getVertex(e.getEndVertex().getData());
                Vertex toVertex = transposedGraph.getVertex(v.getData());
                transposedGraph.addEdge(fromVertex, toVertex, e.getWeight());//Reversing the edge of a vertex
            }
        }
        return transposedGraph;//Return the transposed graph
    }

    public static void main(String[] args) {
        //Testing kosoraju algorithm
        
        Graph graph = new Graph(true, false);
        Vertex v1 = graph.addVertex(1);
        Vertex v2 = graph.addVertex(2);
        Vertex v3 = graph.addVertex(3);
        Vertex v4 = graph.addVertex(4);
        Vertex v5 = graph.addVertex(5);
        Vertex v6 = graph.addVertex(6);
        Vertex v7 = graph.addVertex(7);
        Vertex v8 = graph.addVertex(8);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v3, v1, 1);
        graph.addEdge(v3, v4, 1);
        graph.addEdge(v4, v5, 1);
        graph.addEdge(v5, v6, 1);
        graph.addEdge(v6, v7, 1);
        graph.addEdge(v7, v5, 1);
        graph.addEdge(v7, v8, 1);
        System.out.println("SCC list:  " + Kosaraju.findSCC(graph, v1.getData()));

        
    }
    
}
