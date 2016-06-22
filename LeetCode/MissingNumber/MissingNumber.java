public class Solution {
    public int missingNumber(int[] nums) {
        
        boolean [] valsFound = new boolean[nums.length+1];
        
        for(int i = 0; i < nums.length; i++) {
            valsFound[nums[i]] = true;
        }
        
        int j = 0;
        for(; j < valsFound.length; j++) {
            if(valsFound[j] == false) {
                return j;
            }
        }
        
        return -1;
        
    }
}