class Solution {
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
