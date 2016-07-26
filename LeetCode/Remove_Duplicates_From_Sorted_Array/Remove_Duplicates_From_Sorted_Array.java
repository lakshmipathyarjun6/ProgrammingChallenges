public class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        int current = nums[0];
        int len = 1;
        int overWriteLoc = 1;
        
        for(int i = 1; i < nums.length; i++) {
            while(nums[i] == current) {
                i++;
                if(i >= nums.length) {
                    break;
                }
            }
            if(i >= nums.length) {
                break;
            }
            else {
                nums[overWriteLoc] = nums[i];
                current = nums[i];
                overWriteLoc++;
                len++;
            }
        }
        return len;
    }
}