public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length-1;
        int columns = matrix[0].length-1;
 
        int rowInd = rows; 
        int colInd = 0;
 
        while(rowInd >= 0 && colInd <= columns){
            if(target < matrix[rowInd][colInd]) {
                rowInd--;
            }
            else if(target > matrix[rowInd][colInd]) {
                colInd++;
            }
            else{
                return true;
            }
        }
 
        return false;
    }
}
