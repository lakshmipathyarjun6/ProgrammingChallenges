public class Solution {
    
    private Set<Integer> elementsFound = new HashSet<Integer>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> firstCourseCandidates = new HashSet<Integer>();
        Map<Integer,SearchNode> requisiteMap = new HashMap<Integer,SearchNode>();
        
        for(int i = 0; i < numCourses; i++) {
            firstCourseCandidates.add(i);
            requisiteMap.put(i, new SearchNode());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int [] restriction = prerequisites[i];
            requisiteMap.get(restriction[1]).prereqFor.add(restriction[0]);
            firstCourseCandidates.remove(restriction[0]);
        }
        if(firstCourseCandidates.size() == 0) {
            return false;
        }

        for(Integer start : firstCourseCandidates) {
            if(containsCycle(requisiteMap,start)) {
                return false;
            }
        }
        return elementsFound.size() == numCourses;
    }
    
    private boolean containsCycle(Map<Integer,SearchNode> requisiteMap, Integer current) {
        elementsFound.add(current);
        if(requisiteMap.get(current).visited == true) {
            return true;
        }
        requisiteMap.get(current).visited = true;
        for(Integer possibleNextCourse : requisiteMap.get(current).prereqFor) {
            if(containsCycle(requisiteMap, possibleNextCourse)) {
                return true;
            }
        }
        requisiteMap.get(current).visited = false;
        return false;
    }
}

class SearchNode {
    boolean visited;
    Set<Integer> prereqFor;
    
    public SearchNode() {
        visited = false;
        prereqFor = new HashSet<Integer>();
    }
    
    public String toString() {
        return "Visited: " + visited + " Next courses: " + prereqFor;
    }
}
