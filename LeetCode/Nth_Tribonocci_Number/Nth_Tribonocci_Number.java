class Solution {
    public int tribonacci(int n) {
        int [] nums = new int[n+1];
        
        if(n == 0) {
            return 0;
        }
        else if(n == 1 || n == 2) {
            return 1;
        }
        
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        
        for(int i = 3; i <= n; i++) {
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        }
        
        return nums[n];
    }
}
