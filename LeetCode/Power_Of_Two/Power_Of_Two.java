public class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n == 0) {
            return false;
        }
        
        double epsilon = .00000000000001;
        
        double n_d = Math.log(n) / Math.log(2);
        
        return (Math.abs(Math.round(n_d) - n_d) <= epsilon);
    }
}