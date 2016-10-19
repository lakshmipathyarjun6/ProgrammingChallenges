public class Solution {

    private int [] data;
    private Random r;

    public Solution(int[] nums) {
        data = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int ret = -1;
        if (data == null) {
            return ret;
        }
        
        int ub = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                if (r.nextInt(ub) == 0) {
                    ret = i;
                } 
                ub++;
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
