public class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        
        int [] numsExpanded = new int[2*nums.length];
        for(int i = 0; i < numsExpanded.length; i++) {
            numsExpanded[i] = nums[i%nums.length];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = numsExpanded[i+nums.length-k];
        }
    }
}