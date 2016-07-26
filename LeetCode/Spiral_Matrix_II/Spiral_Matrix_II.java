public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int total = n*n;
        
        int x=0;
        int y=0;
        int step = 0;
        
        for(int i=0 ; i<total; ) {
            while(y+step<n) {
                i++;
                matrix[x][y] = i; 
                y++;
            }    
            y--;
            x++;
 
            while(x+step < n) {
                i++;
                matrix[x][y] = i;
                x++;
            }
            x--;
            y--;
 
            while(y >= 0+step) {
                i++;
                matrix[x][y] = i;
                y--;
            }
            y++;
            x--;
            step++;
 
            while(x >= 0+step) {
                i++;
                matrix[x][y]=i;
                x--;
            }
            x++;
            y++;
        }
        
        return matrix;
    }
}
