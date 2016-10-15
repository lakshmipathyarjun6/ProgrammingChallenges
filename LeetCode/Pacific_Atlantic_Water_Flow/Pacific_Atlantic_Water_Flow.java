public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return result;   
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacificReach = new boolean[m][n];  
        boolean[][] atlanticReach = new boolean[m][n];
        
        for(int i = 0; i < matrix.length; i++){
            pacificReach[i][0] = true;
            atlanticReach[i][matrix[0].length-1] = true;
        }
        for(int i = 0; i < matrix[0].length; i++){
            pacificReach[0][i] = true;
            atlanticReach[matrix.length-1][i] = true; 
        }
        
        for(int row = 0; row < m; row++) {
            boolean[][] pacificFloodplain = new boolean[m][n];
            flood(pacificReach, pacificFloodplain, matrix, row, 0);
            
            boolean[][] atlanticFloodplain = new boolean[m][n];
            flood(atlanticReach, atlanticFloodplain, matrix, row, n-1);            
        }
        for(int column = 0; column < n; column++) {
            boolean[][] pacificFloodplain = new boolean[m][n];
            flood(pacificReach, pacificFloodplain, matrix, 0, column);
            
            boolean[][] atlanticFloodplain = new boolean[m][n];
            flood(atlanticReach, atlanticFloodplain, matrix, m-1, column);            
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacificReach[i][j] && atlanticReach[i][j]){
                    int[] element = {i,j};
                    result.add(element);
                }
            }
        }
        return result;
        
    }
    
    private void flood(boolean [][] oceanReach, boolean [][] floodplain, int [][] matrix, int row, int column) {
        int m = matrix.length;
        int n = matrix[0].length;
        oceanReach[row][column] = true;
        floodplain[row][column] = true;
        int [] deltaY = {1, -1, 0, 0};
        int [] deltaX = {0, 0, 1, -1};
        
        for(int direction = 0; direction < 4; direction++) {
            if(row + deltaY[direction] >= 0 && row + deltaY[direction] < m && column + deltaX[direction] >= 0 && column + deltaX[direction] < n && !floodplain[row + deltaY[direction]][column + deltaX[direction]] && matrix[row + deltaY[direction]][column + deltaX[direction]] >= matrix[row][column]){
                flood(oceanReach, floodplain, matrix, row + deltaY[direction], column + deltaX[direction]);
            }
        }
    }
}
