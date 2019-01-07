class Solution {
    
    public int minFallingPathSum(int[][] A) {
        int minPathSum = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(i > 0) {
                    int leftDiagVal = (j-1 >= 0) ? A[i-1][j-1] : Integer.MAX_VALUE;
                    int dirUpVal = A[i-1][j];
                    int rightDiagVal = (j+1 < A[i].length) ? A[i-1][j+1] : Integer.MAX_VALUE;
                    A[i][j] += Math.min(Math.min(leftDiagVal,dirUpVal),rightDiagVal);
                }
                
                if(i == A.length-1) {
                    minPathSum = Math.min(minPathSum, A[i][j]);
                }
            }
        }
        
        return minPathSum;
    }
}
