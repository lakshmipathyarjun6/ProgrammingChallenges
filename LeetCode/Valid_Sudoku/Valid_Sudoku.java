public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Character[] SET_VALUES = new Character[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<Character> referenceSet = new HashSet<Character>(Arrays.asList(SET_VALUES));
        
        // Check rows
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                else {
                    if(referenceSet.contains(board[i][j])) {
                        referenceSet.remove(board[i][j]);
                    }
                    else {
                        return false; // violation occurred
                    }
                }
            }
            referenceSet = new HashSet<Character>(Arrays.asList(SET_VALUES));
        }
        
        // Check columns
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] == '.') {
                    continue;
                }
                else {
                    if(referenceSet.contains(board[j][i])) {
                        referenceSet.remove(board[j][i]);
                    }
                    else {
                        return false; // violation occurred
                    }
                }
            }
            referenceSet = new HashSet<Character>(Arrays.asList(SET_VALUES));
        }
        
        // Check large grid squares
        for(int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        if(board[k*3 + i][l*3 + j] == '.') {
                            continue;
                        }
                        else {
                            if(referenceSet.contains(board[k*3 + i][l*3 + j])) {
                                referenceSet.remove(board[k*3 + i][l*3 + j]);
                            }
                            else {
                                return false; // violation occurred
                            }
                        }
                    }
                }
                referenceSet = new HashSet<Character>(Arrays.asList(SET_VALUES));
            }
        }
        
        
        return true;
    }
}