class Solution {
    public int determineState(int[][] board, int rowIndex, int columnIndex) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        
        int nwNeighbor = ((rowIndex - 1) >= 0 && (columnIndex - 1) >= 0 && board[rowIndex-1][columnIndex-1] == 1) ? 1 : 0;
        int neNeighbor = ((rowIndex - 1) >= 0 && (columnIndex + 1) < maxCol && board[rowIndex-1][columnIndex+1] == 1) ? 1 : 0;
        int swNeighbor = ((rowIndex + 1) < maxRow && (columnIndex - 1) >= 0 && board[rowIndex+1][columnIndex-1] == 1) ? 1 : 0;
        int seNeighbor = ((rowIndex + 1) < maxRow && (columnIndex + 1) < maxCol && board[rowIndex+1][columnIndex+1] == 1) ? 1 : 0;
        int wNeighbor = ((columnIndex - 1) >= 0 && board[rowIndex][columnIndex-1] == 1) ? 1 : 0;
        int nNeighbor = ((rowIndex - 1) >= 0 && board[rowIndex-1][columnIndex] == 1) ? 1 : 0;
        int sNeighbor = ((rowIndex + 1) < maxRow && board[rowIndex+1][columnIndex] == 1) ? 1 : 0;
        int eNeighbor = ((columnIndex + 1) < maxCol && board[rowIndex][columnIndex+1] == 1) ? 1 : 0;
        
        int totalAliveNeighbors = nwNeighbor + neNeighbor + swNeighbor + seNeighbor + wNeighbor + nNeighbor + sNeighbor + eNeighbor;
        
        int nextCellState = 0;
        if(board[rowIndex][columnIndex] == 1) { // cell is currently alive
            if(totalAliveNeighbors == 2 || totalAliveNeighbors == 3) {
                nextCellState = 1;
            }
        }
        else {
            if(totalAliveNeighbors == 3) {
                nextCellState = 1;
            }
        }
        return nextCellState;
    }
    
    public void gameOfLife(int[][] board) {
        int [][] nextStateBoard = new int[board.length][board[0].length];
        
        for(int i = 0; i < nextStateBoard.length; i++) {
            for(int j = 0; j < nextStateBoard[i].length; j++) {
                nextStateBoard[i][j] = determineState(board, i, j);
            }
        }
        
        for(int i = 0; i < nextStateBoard.length; i++) {
            for(int j = 0; j < nextStateBoard[i].length; j++) {
                board[i][j] = nextStateBoard[i][j];
            }
        }
    }
}
