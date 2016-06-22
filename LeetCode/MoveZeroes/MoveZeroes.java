public class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int switchIndex = -1;
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] != 0) {
                        switchIndex = j;
                        break;
                    }
                }
                if(switchIndex != -1) {
                    nums[i] = nums[switchIndex];
                    nums[switchIndex] = 0;
                }
            }
        }
    }
}