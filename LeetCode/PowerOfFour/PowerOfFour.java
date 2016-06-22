public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0) {
            return false;
        }
        
        double epsilon = .00000000000001;
        
        double n_d = Math.log(num) / Math.log(4);
        
        return (Math.abs(Math.round(n_d) - n_d) <= epsilon);
    }
}