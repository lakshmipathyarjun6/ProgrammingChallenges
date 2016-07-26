public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            Integer val = freq.get(nums[i]);
            if(val == null) {
                freq.put(nums[i],1);
            }
            else {
                if(val+1 > nums.length/2) {
                    return nums[i];
                }
                freq.put(nums[i],val+1);
            }
        }
        
        return 0;
    }
}