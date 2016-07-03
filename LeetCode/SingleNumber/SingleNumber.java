public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> foundVals = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(foundVals.contains(nums[i])) {
                foundVals.remove(nums[i]);
            }
            else {
                foundVals.add(nums[i]);
            }
        }
        
        return foundVals.toArray(new Integer[1])[0];
    }
}