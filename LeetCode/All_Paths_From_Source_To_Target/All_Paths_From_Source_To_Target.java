class Solution {
    Set<List<Integer>> paths;
    
    public void dfs(List<Integer> currPath, int[][] graph, int current) {
        List<Integer> currPathNew = new ArrayList<Integer>(currPath);
        currPathNew.add(current);
        if(current == graph.length-1) {
            paths.add(currPathNew);
        }
        
        for(int i = 0; i < graph[current].length; i++) {
            dfs(currPathNew, graph, graph[current][i]);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new HashSet<List<Integer>>();
        dfs(new LinkedList<Integer>(), graph, 0);
        List<List<Integer>> allPaths = new LinkedList<List<Integer>>(paths);
        return allPaths;
    }
}
