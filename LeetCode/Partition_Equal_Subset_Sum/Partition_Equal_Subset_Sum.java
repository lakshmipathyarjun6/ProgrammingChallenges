public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums != null && nums.length == 0;
        }
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        
        int [] results = new int[sum/2];
        return canPartitionHelper(sum/2, 0, 0, nums, results);
    }
    
    private boolean canPartitionHelper(int max,int current, int index, int[] nums, int [] results) {
        if(index >= nums.length || current > max) {
            return false;
        }
        else if(current == max) {
            return true;
        }
        else if(results[current] != 0) {
            return (results[current] == 1) ? true : false;
        }
        
        boolean result = canPartitionHelper(max, current + nums[index], index + 1, nums, results) || canPartitionHelper(max, current, index + 1, nums, results);
        results[current] = result ? 1 : -1;
        return result;
    }
}
