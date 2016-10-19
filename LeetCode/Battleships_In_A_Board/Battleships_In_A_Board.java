public class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int totalShips = 0;
        
        int m = board.length;
        int n = board[0].length;
        
        char [][] visited = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    if(visited[i][j] != 'V') {
                        markShip(board, visited, i, j);
                        totalShips++;
                    }
                }
                else {
                    visited[i][j] = '.';
                }
            }
        }
        
        return totalShips;
    }
    
    private void markShip(char[][] board, char[][] visited, int row, int column) {
        boolean direction = (row+1 < board.length && board[row+1][column] == 'X');
        while(row < board.length && column < board[row].length && board[row][column] == 'X') {
            visited[row][column] = 'V';
            if(direction) {
                row++;
            }
            else {
                column++;
            }
        }
    }
}
