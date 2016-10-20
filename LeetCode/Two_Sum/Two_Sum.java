public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] pair = new int[2];
        Map<Integer,Integer> indices = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(indices.containsKey(target - nums[i])) {
                pair[0] = indices.get(target - nums[i]);
                pair[1] = i;
                break;
            }
            else {
                indices.put(nums[i], i);
            }
        }
        
        return pair;
    }
}
