public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> foundVals = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(foundVals.contains(nums[i])) {
                return true;
            }
            foundVals.add(nums[i]);
        }
        
        return false;
    }
}
