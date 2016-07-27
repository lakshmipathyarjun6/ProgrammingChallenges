public class Solution {
    
    static class PQsort implements Comparator<Integer> {
        
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        PQsort pqs = new PQsort();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, pqs);
        
        for(int x : nums) {
            pq.offer(x);
        }
        
        int retval = 0;
        while(k > 0) {
            retval = pq.poll();
            k--;
        }
        return retval;
    }
}