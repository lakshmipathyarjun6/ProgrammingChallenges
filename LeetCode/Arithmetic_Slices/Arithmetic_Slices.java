public class Solution {
    public int numberOfArithmeticSlices(int [] A) {
        int numSlices = 0;
        if(A == null || A.length < 3) {
            return numSlices;
        }
        
        int windowStartIndex = 0;
        int windowEndIndex = 1;
        
        while(windowEndIndex < A.length) {
            int arithmeticDiff = A[windowEndIndex] - A[windowStartIndex];
            while(windowEndIndex < A.length && A[windowEndIndex] == A[windowStartIndex] + (windowEndIndex - windowStartIndex)*arithmeticDiff) {
                windowEndIndex++;
            }
            int windowSize = windowEndIndex - windowStartIndex;
            numSlices += (windowSize - 2)*(windowSize - 1)/2;
            windowStartIndex = windowEndIndex - 1;
        }
        
        return numSlices;
    }
}
