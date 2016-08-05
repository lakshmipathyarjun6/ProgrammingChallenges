public class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();
    
    public List<String> findItinerary(String[][] tickets) { // this is a topological sort problem
        for (String [] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
 
        dfs("JFK");
        Collections.reverse(itinerary);
        
        return itinerary;
    }
    
    public void dfs(String s) {
        PriorityQueue<String> q = map.get(s);
 
        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }
 
        itinerary.add(s);
    }
}
