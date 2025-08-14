import java.util.ArrayList;
import java.util.List;

public class MinPoints{

    public static int minDistance(int[][] coordinates){
        List<Integer> visited = new ArrayList<>();
        Graph graph = new Graph(false, true);
        for(int i = 0; i < coordinates.length - 1; i++){
            for(int j = i + 1; j < coordinates.length; j++){
                if(j != i){
                    Vertex v1 = new Vertex(i);
                    Vertex v2 = new Vertex(j);
                    int weight = ((coordinates[i][0] - coordinates[j][0]) + (coordinates[i][1] - coordinates[j][1]));
                    if(weight < 0){
                        weight = -weight;
                    }
                    if(!visited.contains(i)){
                        v1 = graph.addVertex(i);
                        visited.add(i);
                    } else{
                        v1 = graph.getVertex(i);
                    }
                    if(!visited.contains(j)){
                        v2 = graph.addVertex(j);
                        visited.add(j);
                    } else{
                        v2 = graph.getVertex(j);
                    }
                    graph.addEdge(v1, v2, weight);
                }
            }
        }
        return(MinimumSpanningTree.findMinimum(graph, graph.getVertex(0)));
    }
    public static void main(String[] args){
        int[][] coordinates = {{0,0},{2,2},{3,10},{5,2},{7,0}};//Expected output: 20
        System.out.println(MinPoints.minDistance(coordinates));
    }
}