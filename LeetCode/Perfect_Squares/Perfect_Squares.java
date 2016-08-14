public class Solution {
    public int numSquares(int n) {
        int upperBound = (int) Math.sqrt(n);
 
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= upperBound; j++){
                if(i == j*j){
                    result[i] = 1;
                }
                else if(i > j*j) {
                    result[i] = Math.min(result[i], result[i-j*j] + 1);
                }
            }
        }
 
        return result[n];
    }
}
