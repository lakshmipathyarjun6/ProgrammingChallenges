import java.util.*;

class Solution {
    
    Set<Integer> visited;
    
    public void performDFS(Map<Integer,Node> graph, Node current) {
        for(Integer uv : current.edges) {
            if(!visited.contains(uv)) {
                visited.add(uv);
                performDFS(graph, graph.get(uv));
            }
        }
    }
    
    public int findCircleNum(int[][] M) {
        Map<Integer,Node> friendGraph = new HashMap<Integer,Node>();
        
        for(int i = 0; i < M.length; i++) {
            Node n = new Node(i);
            for(int j = 0; j < M[i].length; j++) {
                if(M[i][j] == 1) {
                    n.edges.add(j);
                } 
            }
            friendGraph.put(i,n);
        }
        
        visited = new HashSet<Integer>();
        
        int totalCircles = 0;
        while(visited.size() < friendGraph.keySet().size()) {
            for(Integer key : friendGraph.keySet()) {
                if(!visited.contains(key)) {
                    performDFS(friendGraph, friendGraph.get(key));
                    break;
                }     
            }
            totalCircles++;
        }

        return totalCircles;
    }
}

class Node {
    Integer vertexValue;
    Set<Integer> edges;
    
    public Node(Integer v) {
        this.vertexValue = v;
        this.edges = new HashSet<Integer>();
    }
}
