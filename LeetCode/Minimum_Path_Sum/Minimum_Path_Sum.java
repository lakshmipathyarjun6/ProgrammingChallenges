public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        
        int [][] sumGrid = new int[grid.length][grid[0].length];
        sumGrid[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        
        for(int j = grid[0].length-2; j >= 0; j--) {
            sumGrid[grid.length-1][j] = sumGrid[grid.length-1][j+1] + grid[grid.length-1][j];
        }
        
        for(int i = grid.length-2; i >= 0; i--) {
            sumGrid[i][grid[0].length-1] = sumGrid[i+1][grid[0].length-1] + grid[i][grid[0].length-1];
        }
        
        for(int i = sumGrid.length-2; i >= 0; i--) {
            for(int j = sumGrid[i].length-2; j >= 0; j--) {
                sumGrid[i][j] = Math.min(sumGrid[i+1][j],sumGrid[i][j+1]) + grid[i][j];
            }
        }
        
        return sumGrid[0][0];
    }
}
