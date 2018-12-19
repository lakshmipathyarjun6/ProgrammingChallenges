class Solution {
    public int getMineCount(char[][] board, int rowInd, int colInd) {
        int mineCount = 0;
        if(rowInd-1 >= 0 && colInd-1 >= 0 && board[rowInd-1][colInd-1] == 'M') {
            mineCount++;
        }
        if(rowInd-1 >= 0 && board[rowInd-1][colInd] == 'M') {
            mineCount++;
        }
        if(rowInd-1 >= 0 && colInd+1 < board[0].length && board[rowInd-1][colInd+1] == 'M')
        {
            mineCount++;
        }
        if(colInd-1 >= 0 && board[rowInd][colInd-1] == 'M') {
            mineCount++;
        }
        if(colInd+1 < board[0].length && board[rowInd][colInd+1] == 'M') {
            mineCount++;
        }
        if(rowInd+1 < board.length && colInd-1 >= 0 && board[rowInd+1][colInd-1] == 'M') {
            mineCount++;
        }
        if(rowInd+1 < board.length && board[rowInd+1][colInd] == 'M') {
            mineCount++;
        }
        if(rowInd+1 < board.length && colInd+1 < board[0].length && board[rowInd+1][colInd+1] == 'M') {
            mineCount++;
        }
        return mineCount;
    }
    
    public void floodFillBoard(char[][] board, int rowInd, int colInd) {
        if(rowInd < 0 || colInd < 0 || rowInd >= board.length || colInd >= board[0].length) 
        {
            return;
        }
        else if(board[rowInd][colInd] == 'M') {
            board[rowInd][colInd] = 'X';
            return;
        }
        else if(board[rowInd][colInd] != 'E')
        {
            return;
        }
        int mineCount = getMineCount(board, rowInd, colInd);
        if(mineCount > 0) {
            char fillValue = (char)(mineCount + '0');
            board[rowInd][colInd] = fillValue;
            return;
        }
        else {
            board[rowInd][colInd] = 'B';
            floodFillBoard(board, rowInd-1, colInd-1);
            floodFillBoard(board, rowInd-1, colInd);
            floodFillBoard(board, rowInd-1, colInd+1);
            floodFillBoard(board, rowInd, colInd-1);
            floodFillBoard(board, rowInd, colInd+1);
            floodFillBoard(board, rowInd+1, colInd-1);
            floodFillBoard(board, rowInd+1, colInd);
            floodFillBoard(board, rowInd+1, colInd+1);
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        floodFillBoard(board, click[0], click[1]);
        return board;
    }
}
