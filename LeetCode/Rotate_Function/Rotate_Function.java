public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        
        int [] doubleA = new int[A.length*2];
        for(int i = 0; i < doubleA.length; i++) {
            doubleA[i] = A[i % A.length];
        }
        
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 0; i < A.length; i++) {
            int sum = 0;
            for(int j = 0; j < A.length; j++) {
                sum += j * doubleA[j+i];
            }
            maxVal = (sum > maxVal) ? sum : maxVal;
        }
        
        return maxVal;
    }
}
