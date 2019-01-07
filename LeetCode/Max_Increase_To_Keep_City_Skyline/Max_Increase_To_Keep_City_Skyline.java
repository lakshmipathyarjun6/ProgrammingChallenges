class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        Map<Integer, Integer> rowMax = new HashMap<Integer,Integer>();
        Map<Integer, Integer> colMax = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(rowMax.containsKey(i)) {
                    rowMax.put(i, Math.max(grid[i][j],rowMax.get(i)));
                }
                else {
                    rowMax.put(i, grid[i][j]);
                }
                
                if(colMax.containsKey(j)) {
                    colMax.put(j, Math.max(grid[i][j],colMax.get(j)));
                }
                else {
                    colMax.put(j, grid[i][j]);
                }
            }
        }
        
        int totalBuildUp = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                totalBuildUp += Math.min(rowMax.get(i), colMax.get(j)) - grid[i][j];
            }
        }
        
        return totalBuildUp;
    }
}
