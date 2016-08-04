public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int [] combos = new int[target+1];
        combos[0] = 1;
 
        for(int i = 0; i <= target; i++){
            for(int k = 0; k < nums.length; k++){
                if(i + nums[k] <= target){
                    combos[i+nums[k]] += combos[i];
                }
            }
        }
        
        return combos[target];
    }
}
