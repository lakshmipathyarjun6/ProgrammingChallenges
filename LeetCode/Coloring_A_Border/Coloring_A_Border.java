class Solution {
    boolean[][] paint;
    boolean[][] visited;
    
    public void findBorder(int[][] grid, int row, int col, int target) {
        if(row < 0 || row >= grid.length) {
            return;
        }
        else if(col < 0 || col >= grid[0].length) {
            return;
        }
        else if(visited[row][col] == true) {
            return;
        }
        
        visited[row][col] = true;
        
        if(grid[row][col] != target) {
            return;
        }
        
        boolean isTopBorder = (row - 1 < 0) || (grid[row - 1][col] != target);
        boolean isBottomBorder = (row + 1 >= grid.length) || (grid[row + 1][col] != target);
        boolean isLeftBorder = (col - 1 < 0) || (grid[row][col - 1] != target);
        boolean isRightBorder = (col + 1 >= grid[0].length) || (grid[row][col + 1] != target);
        
        if(isTopBorder || isBottomBorder || isLeftBorder || isRightBorder) {
            paint[row][col] = true;
        }
        
        findBorder(grid, row - 1, col, target);
        findBorder(grid, row + 1, col, target);
        findBorder(grid, row, col - 1, target);
        findBorder(grid, row, col + 1, target);
    }
    
    public void fillBorder(int[][] grid, int color) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(paint[i][j] == true) {
                    grid[i][j] = color;
                }
            }
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        paint = new boolean[grid.length][grid[0].length];
        visited = new boolean[grid.length][grid[0].length];
        
        int entry = grid[row][col];
        
        for (boolean[] r: visited) {
            Arrays.fill(r, false);
        }
        for (boolean[] r: paint) {
            Arrays.fill(r, false);
        }
        
        findBorder(grid, row, col, entry);
        fillBorder(grid, color);
        
        return grid;
    }
}
