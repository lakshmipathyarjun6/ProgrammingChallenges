public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        else if(nums.length == 1) {
            return nums[0];
        }
        
        int max1 = robHelper(nums, 0, nums.length-2);
        int max2 = robHelper(nums, 1, nums.length-1);
 
        return Math.max(max1, max2);
    }
    
    public int robHelper(int [] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }
        
        int [] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1]=Math.max(nums[start+1], dp[start]);
 
        for(int i = start+2; i <= end; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);    
        }
 
        return dp[end];
    }
}
