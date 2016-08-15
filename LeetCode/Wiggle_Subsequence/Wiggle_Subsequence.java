public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0) {
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }    
 
        int count=1;
 
        int currentIndex = 0;
        for(int jumpIndex = 1; jumpIndex < nums.length; jumpIndex++) {
            if(nums[currentIndex] < nums[jumpIndex]) {
                count++;
                while(jumpIndex < nums.length-1 && nums[jumpIndex] <= nums[jumpIndex+1]) { // skip ahead
                    jumpIndex++;
                }
            }
            else if(nums[currentIndex] > nums[jumpIndex]) {
                count++;
                while(jumpIndex < nums.length-1 && nums[jumpIndex] >= nums[jumpIndex+1]) { // skip ahead
                    jumpIndex++;
                }
            }
            currentIndex = jumpIndex;
        }
 
        return count;
    }
}
