public class Solution {
    public int climbStairs(int n) {
        
        int [] arr = new int[n+1];
        arr[0] = 1;
        
        int i = 1;
        for(; i <= n; i++) {
            int twoStepsBack = (i-2 >= 0) ? arr[i-2] : 0;
            int oneStepBack = arr[i-1];
            arr[i] = oneStepBack + twoStepsBack;
        }
        
        return arr[i-1];
    }
}