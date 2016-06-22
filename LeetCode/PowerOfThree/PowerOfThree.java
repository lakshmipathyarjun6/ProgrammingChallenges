public class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n == 0) {
            return false;
        }
        
        double epsilon = .00000000000001;
        
        double n_d = Math.log(n) / Math.log(3);
        
        return (Math.abs(Math.round(n_d) - n_d) <= epsilon);
    }
}