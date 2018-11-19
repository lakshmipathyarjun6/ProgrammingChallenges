public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null) {
            return 0;
        }
        int [] maxSums = new int[nums.length];
        maxSums[0] = nums[0];
        
        for(int i = 1; i < maxSums.length; i++) {
            maxSums[i] = Math.max(nums[i],nums[i]+maxSums[i-1]);
        }
        
        int maxVal = maxSums[maxSums.length-1];
        for(int i = 0; i < maxSums.length; i++) {
            maxVal = Math.max(maxVal,maxSums[i]);
        }
        
        return maxVal;
    }
}
