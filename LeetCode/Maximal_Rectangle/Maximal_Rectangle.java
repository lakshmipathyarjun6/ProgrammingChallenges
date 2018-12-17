class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        
        int [][] heightMatrix = constructHeightMatrix(matrix);
        
        int maxRect = 0;
        for(int i = 0; i < heightMatrix.length; i++) {
            int [] hist = heightMatrix[i];
            maxRect = Math.max(maxRect, largestRectangleArea(hist));
        }
        
        return maxRect;
    }
    
    public int[][] constructHeightMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] heightMatrix = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(i == 0) {
                    heightMatrix[i][j] = Character.getNumericValue(matrix[i][j]);
                }
                else {
                    if(matrix[i][j] == '0') {
                        heightMatrix[i][j] = 0;
                    }
                    else {
                        heightMatrix[i][j] = (matrix[i-1][j] == '1') ? heightMatrix[i-1][j] + 1 : 1;
                    }                    
                }
            }
        }
        
        return heightMatrix;
    }
    
    public int largestRectangleArea(int[] heights) {
        int index = 0;
        int maxArea = 0;
        int length = heights.length;
        Stack<Integer> indexStack = new Stack<Integer>();

        while(index < length) {
            if(indexStack.empty() || heights[indexStack.peek()] < heights[index]) {
                indexStack.push(index);
                index++;
            }
            else {
                Integer topIndPop = indexStack.pop();
                int multiplier = (indexStack.empty()) ? index : index - indexStack.peek() - 1;
                maxArea = Math.max(maxArea, heights[topIndPop]*multiplier);
            }
        }
        
        while(!indexStack.empty()) {
            Integer topIndPop = indexStack.pop();
            int multiplier = (indexStack.empty()) ? index : index - indexStack.peek() - 1;
            maxArea = Math.max(maxArea, heights[topIndPop]*multiplier);
        }

        return maxArea;
    }
    
}
