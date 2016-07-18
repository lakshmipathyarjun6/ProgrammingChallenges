public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        else if(nums.length == 1) {
            return nums[0];
        }
        else if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        
        int [] maxes = new int[nums.length];
        maxes[0] = nums[0];
        maxes[1] = Math.max(maxes[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            maxes[i] = Math.max(maxes[i-1],nums[i]+maxes[i-2]);
        }
        
        return maxes[maxes.length-1];
    }
}
