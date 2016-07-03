public class Solution {
    public int candy(int[] ratings) {
        int [] vals = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
            vals[i] = 1;
        }
        
        for(int i = 1; i < vals.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                vals[i] = vals[i-1] + 1;
            }
        }
        
        for(int i = vals.length-2; i > -1; i--) {
            if(ratings[i] > ratings[i+1]) {
                vals[i] = Math.max(vals[i], vals[i+1]+1);
            }
        }
        
        int sum = 0;
        for(int i = 0; i < vals.length; i++) {
            sum += vals[i];
        }
        
        return sum;
    }
}