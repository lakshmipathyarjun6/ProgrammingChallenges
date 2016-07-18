public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
 
        max[0] = nums[0];
        min[0] = nums[0];
        int maxVal = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }
            else {
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }
 
            maxVal = Math.max(maxVal, max[i]);
        }
        
        return maxVal;
    }
}
