public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                flood(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                flood(board, i, n-1);
            }
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                flood(board, 0, j);
            }
            if(board[m-1][j] == 'O') {
                flood(board, m-1, j);
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = (board[i][j] == 'F') ? 'O' : 'X';
            }
        }
    }
    
    private void flood(char [][] board, int row, int column) {
        int m = board.length;
        int n = board[0].length;
 
        int index = row*n + column;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        board[row][column]='F';

        while(!queue.isEmpty()) {
            int top = queue.poll();
            int i = top / n;
            int j = top % n;
 
            if(i-1 >= 0 && board[i-1][j] == 'O'){
                board[i-1][j] = 'F';
                queue.offer((i-1)*n + j);
            }
            if(i+1 < m && board[i+1][j] == 'O'){
                board[i+1][j] = 'F';
                queue.offer((i+1)*n + j);
            }
            if(j-1 >= 0 && board[i][j-1] == 'O'){
                board[i][j-1] = 'F';
                queue.offer(i*n + j-1);
            }
            if(j+1 < n && board[i][j+1] == 'O'){
                board[i][j+1] = 'F';
                queue.offer(i*n + j+1);
            }
        }
    }
}
