public class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
 
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
 
            if (firstNum >= target) {
                firstNum = target;
            } 
            else if (secondNum >= target) {
                secondNum = target; 
            } 
            else {
                return true;
            }
        }
 
        return false;
    }
}
