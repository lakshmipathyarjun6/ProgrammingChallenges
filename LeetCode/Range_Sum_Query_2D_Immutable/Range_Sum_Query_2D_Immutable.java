public class NumMatrix {
    
    private List<List<Integer>> mat;
    
    public NumMatrix(int[][] matrix) {
        
        mat = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < matrix.length; i++) {
            List<Integer> row = new ArrayList<Integer>();
            mat.add(row);
            for(int j = 0; j < matrix[i].length; j++) {
                row.add((j-1 >= 0) ? (mat.get(i).get(j-1) + matrix[i][j]) : matrix[i][j]);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for(int i = row1; i <= row2; i++) {
            total += (col1-1 >= 0) ? (mat.get(i).get(col2) - mat.get(i).get(col1-1)) : mat.get(i).get(col2);
        }
        return total;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);