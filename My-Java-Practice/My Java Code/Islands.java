import java.util.ArrayList;
import java.util.List;

public class Islands{

    public static int findIslands(int[][] grid){
        Graph graph = new Graph(false, false);
        //Initialising the matrix as a graph
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                graph.addVertex(grid[i][j]);
                if(j - 1 >= 0){
                    graph.addEdge(new Vertex(grid[i][j]), new Vertex(grid[i][j - 1]), 0);
                }
                if(j + 1 < grid[i].length){
                    graph.addEdge(new Vertex(grid[i][j]), new Vertex(grid[i][j + 1]), 0);
                }
                if(i - 1 >= 0){
                    graph.addEdge(new Vertex(grid[i][j]), new Vertex(grid[i - 1][j]), 0);
                }
                if(i + 1 < grid.length){
                    graph.addEdge(new Vertex(grid[i][j]), new Vertex(grid[i + 1][j]), 0);
                }
            }
        }
        //Calculating the number of islands in the matrix
        int num = IslandSearch(graph, grid[0][0]);
        return num;
        
    }

    public static int IslandSearch(Graph graph, int root){
        int numIslands = 0;
        List<Integer> visited = new ArrayList<>();
        MyStack stack = new MyStack();
        stack.push(root);
        while(!stack.isEmpty()){
            int currentData = stack.pop();
            if (!visited.contains(currentData)) {
                visited.add(currentData);
                if(currentData == 1){
                    numIslands++;
                }
                // Get the current vertex from the graph
                Vertex currentVertex = graph.getVertex(currentData);
                if (currentVertex != null) {
                    for (Edge e : currentVertex.getEdges()) {
                        Vertex nextVertex = e.getEndVertex();
                        if (!visited.contains(nextVertex.getData())) {
                            stack.push(nextVertex.getData());
                        }
                    }
                }
            }
        }
        //returning number of islands found in the matrix
        return numIslands;
    }

    public static void main(String[] args) {
        int[][] IslandMatrix = {
            {1,1,0,0},
            {1,0,0,0},
            {0,1,1,1},
            {0,0,0,0},
            {1,1,0,0}
        };
        System.out.println(Islands.findIslands(IslandMatrix));
    }
}