public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> foundVals = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(foundVals.containsKey(nums[i])) {
                if(Math.abs(foundVals.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            foundVals.put(nums[i],i);
        }
        
        return false;
    }
}
