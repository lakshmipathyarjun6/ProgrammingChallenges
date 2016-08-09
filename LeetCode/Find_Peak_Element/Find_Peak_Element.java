public class Solution {
    public int findPeakElement(int[] nums) {
        Queue<Range> queue = new LinkedList<Range>();
        Range searchRange = new Range(0,nums.length-1);
        queue.add(searchRange);
        
        while(queue.size() > 0) {
            searchRange = queue.remove();
            int mid = searchRange.lb + (searchRange.ub-searchRange.lb)/2;
            long left = (mid-1 >= 0) ? (long) nums[mid-1] : Long.MIN_VALUE;
            long right = (mid+1 < nums.length) ? (long) nums[mid+1] : Long.MIN_VALUE;
            if((long) nums[mid] > left && (long) nums[mid] > right) {
                return mid;
            }
            if(mid-1 >= searchRange.lb) {
                Range leftRange = new Range(searchRange.lb,mid-1);
                queue.add(leftRange);
            }
            if(mid+1 <= searchRange.ub) {
                Range rightRange = new Range(mid+1,searchRange.ub);
                queue.add(rightRange);
            }
        }
        
        return -1;
    }
}

class Range {
    int lb;
    int ub;
    
    public Range(int Lb, int Ub) {
        lb = Lb;
        ub = Ub;
    }
}
