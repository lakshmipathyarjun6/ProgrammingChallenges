public class Solution {
    public int numIslands(char[][] grid) {
        int total = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    total++;
                    markOffIsland(grid, i, j);
                }
            }
        }
        return total;
    }
    
    private void markOffIsland(char [][] grid, int row, int column) {
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != '1') {
            return;
        }
        grid[row][column] = 'V'; // mark as visited
        markOffIsland(grid, row - 1, column);
        markOffIsland(grid, row + 1, column);
        markOffIsland(grid, row, column - 1);
        markOffIsland(grid, row, column + 1);
    }
}
