public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k < 0 || t < 0) {
            return false;
        }
        
        int i = 0; 
        int j = 0;
        TreeSet<Double> candidateSet = new TreeSet<Double>();
        while(j < nums.length && j - i <= k) {
            double val = nums[j];
            double lb = val - t;
            double ub = val + t + 1;
            SortedSet<Double> targetSet = candidateSet.subSet(lb, ub);
            if(targetSet.size() > 0) {
                return true;
            }
            
            candidateSet.add(val);
            j++;
        }
        
        if(j == nums.length) {
            return false;
        }
        else {
            candidateSet.remove((double) nums[i]);
            i++;
        }
        
        while(j < nums.length) {
            double val = nums[j];
            double lb = val - t;
            double ub = val + t + 1;
            SortedSet<Double> targetSet = candidateSet.subSet(lb, ub);
            if(targetSet.size() > 0) {
                return true;
            }
            
            double baseVal = nums[i];
            candidateSet.remove(baseVal);
            candidateSet.add(val);
            i++;
            j++;
        }
        
        return false;
    }
}
