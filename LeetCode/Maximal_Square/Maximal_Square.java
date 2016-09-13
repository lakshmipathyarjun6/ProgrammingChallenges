public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max_size = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    int k = 0;
                    boolean foundZero = false;
                    while(!foundZero) {
                        k++;
                        int counter = 0;
                        while(counter <= k) {
                            char val1 = (i+k < matrix.length) ? matrix[i+k][j+counter] : '0';
                            char val2 = (j+k < matrix[i].length) ? matrix[i+counter][j+k] : '0';
                            if(val1 != '1' || val2 != '1') {
                                foundZero = true;
                                break;
                            }
                            counter++;
                        }
                    }
                    max_size = (k*k > max_size) ? k*k : max_size; 
                }
            }
        }
        return max_size;
    }
}
