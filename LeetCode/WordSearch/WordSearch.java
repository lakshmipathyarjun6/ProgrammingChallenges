public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char [][] board, String word, int row, int column, int strIndex) {
        if(strIndex == word.length()) {
            return true;
        }
        
        if(row < 0 || row == board.length || column < 0 || column == board[0].length) {
            return false;
        }
        
        if(board[row][column] == word.charAt(strIndex)) {
            char temp = board[row][column];
            board[row][column] = '#';
        
            if(dfs(board,word,row+1,column,strIndex+1) || dfs(board,word,row-1,column,strIndex+1) || dfs(board,word,row,column+1,strIndex+1) || dfs(board,word,row,column-1,strIndex+1)) {
                return true;
            }
        
            board[row][column] = temp;
        }
        
        return false;
    }
}
