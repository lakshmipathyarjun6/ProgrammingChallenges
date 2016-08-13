public class Solution {
    
    private Set<Integer> elementsFound = new HashSet<Integer>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> firstCourseCandidates = new HashSet<Integer>();
        Map<Integer,SearchNode> requisiteMap = new HashMap<Integer,SearchNode>();
        List<Integer> intermediateResult = new LinkedList<Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            firstCourseCandidates.add(i);
            requisiteMap.put(i, new SearchNode());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int [] restriction = prerequisites[i];
            requisiteMap.get(restriction[1]).prereqFor.add(restriction[0]);
            firstCourseCandidates.remove(restriction[0]);
            requisiteMap.get(restriction[0]).prereqs.add(restriction[1]);
        }
        if(firstCourseCandidates.size() == 0) {
            return new int[0];
        }
        
        for(Integer start : firstCourseCandidates) {
            Map<Integer,SearchNode> requisiteMapCopy = new HashMap<Integer,SearchNode>(requisiteMap);
            intermediateResult.addAll(bfs(requisiteMapCopy,start));
            if(elementsFound.size() == numCourses) {
                break;
            }
        }
        if(elementsFound.size() < numCourses) {
            return new int[0];
        }
        
        int [] finalResult = new int[numCourses];
        for(int i = 0; i < finalResult.length; i++) {
            finalResult[i] = intermediateResult.get(i);
        }
        return finalResult;
    }
    
    private List<Integer> bfs(Map<Integer,SearchNode> requisiteMap, Integer start) {
        List<Integer> courseOrdering = new LinkedList<Integer>();
        Queue<Integer> courses = new LinkedList<Integer>();
        courses.offer(start);
        while(courses.size() > 0) {
            Integer course = courses.poll();
            elementsFound.add(course);
            requisiteMap.get(course).visited = true;
            courseOrdering.add(course);
            for(Integer nextPossibleCandidate : requisiteMap.get(course).prereqFor) {
                requisiteMap.get(nextPossibleCandidate).prereqs.remove(course);
                if(requisiteMap.get(nextPossibleCandidate).prereqs.size() == 0 && !requisiteMap.get(nextPossibleCandidate).visited) {
                    courses.offer(nextPossibleCandidate);
                }
            }
        }
        return courseOrdering;
    }
}

class SearchNode {
    boolean visited;
    Set<Integer> prereqs;
    Set<Integer> prereqFor;
    
    public SearchNode() {
        visited = false;
        prereqs = new HashSet<Integer>();
        prereqFor = new HashSet<Integer>();
    }
    
    public String toString() {
        return "Visited: " + visited + " Prereqs: " + prereqs + " Next courses: " + prereqFor;
    }
}
