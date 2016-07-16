public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> master = new ArrayList<List<Integer>>();
 
        if (n <= 0 || n < k) {
            return master;
        }
 
        List<Integer> current = new ArrayList<Integer>();
        createCombs(n, k, 1, current, master); // because it need to begin from 1
 
        return master;
        
    }
    
    public void createCombs(int n, int k, int start, List<Integer> current, List<List<Integer>> master) {
        if(current.size() == k) {
            master.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            createCombs(n, k, i + 1, current, master);
            current.remove(current.size() - 1);
        }
    }
}
