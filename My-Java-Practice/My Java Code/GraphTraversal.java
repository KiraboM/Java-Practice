import java.util.ArrayList;
import java.util.List;

public class GraphTraversal{

    public static List<Integer> dfs(Graph graph, int root, int[][] prerequisites, int numCourse){
        List<Integer> visited = new ArrayList<>();
        List<Integer> courseList = new ArrayList<>();
        MyStack stack = new MyStack();
        stack.push(root);
        while(!stack.isEmpty()){
            int currentData = stack.pop();
            System.out.println(currentData);
            if (!visited.contains(currentData)) {
                visited.add(currentData);
                // Get the current vertex from the graph
                Vertex currentVertex = graph.getVertex(currentData);
                if (currentVertex != null) {
                    for (Edge e : currentVertex.getEdges()) {
                        Vertex nextVertex = e.getEndVertex();
                        for(int i = 0; i < prerequisites.length; i++){
                            if(prerequisites[i][0] == currentData && prerequisites[i][1] == nextVertex.getData()){
                                if(!courseList.contains(currentData)){
                                    courseList.add(currentData);
                                    //System.out.println(courseList);
                                }
                                if(!courseList.contains(nextVertex.getData())){
                                    courseList.add(nextVertex.getData());
                                  // System.out.println(courseList);
                                }
                            }
                        }
                        if (!visited.contains(nextVertex.getData())) {
                            stack.push(nextVertex.getData());
                        }
                    }
                }
            }
        }
        if(courseList.size() >= numCourse - 1){
            return courseList;    
        } else{
            return new ArrayList<>(); //Return empty list if you can't reach all the courses
        }
    }
}
