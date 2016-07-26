public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return 0;
        }
        System.out.println(nums.length);
        int minWindowLen = nums.length;
        boolean windowLenUnchanged = true;
        int currentSum = 0;
        int start = 0; 
        int end = 0;
        while (end <= nums.length) {
            if (currentSum < s) {
                if(end >= nums.length) {
                    break;
                }
                currentSum += nums[end];
                end++;
            }
            else {
                windowLenUnchanged = false; 
                if(start == end-1) {
                    return 1;
                }
                
                minWindowLen = Math.min(minWindowLen, end-start);
                currentSum -= nums[start];
                start++;
            }
        }
        if(windowLenUnchanged) {
            return 0;
        }
        return minWindowLen;
    }
}
