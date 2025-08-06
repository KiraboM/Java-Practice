import java.util.ArrayList;
import java.util.List;

public class Courses{

    public static List<Integer> findCourses(int[][] prerequisites, int numCourses){
        Graph courseGraph = new Graph(true, false);
        List<Integer> visited = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++){
            Vertex startVertex = null;
            Vertex endVertex = null;
            if(!visited.contains(prerequisites[i][0])){
                 startVertex = courseGraph.addVertex(prerequisites[i][0]);
                 visited.add(prerequisites[i][0]);
            } else{
                startVertex = courseGraph.getVertex(prerequisites[i][0]);
            }
            if(!visited.contains(prerequisites[i][1])){
                 endVertex = courseGraph.addVertex(prerequisites[i][1]);
                 visited.add(prerequisites[i][1]);
            } else{
                endVertex = courseGraph.getVertex(prerequisites[i][1]);
            }
            courseGraph.addEdge(startVertex, endVertex, 1);
        }
        return GraphTraversal.dfs(courseGraph, prerequisites[0][0], prerequisites, numCourses);
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1},{0,2},{1,3},{2,3}};
        Courses courses = new Courses();
        System.out.println(Courses.findCourses(prerequisites, 4)); //returns [0,2,1,3]
    }
}


