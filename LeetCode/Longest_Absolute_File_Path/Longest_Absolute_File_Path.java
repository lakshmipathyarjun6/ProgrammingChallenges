public class Solution {
    public int lengthLongestPath(String input) {
        if(input.equals("") || !input.contains(".")) {
            return 0;
        }
        
        Stack<String> stack = new Stack<String>();
        int maxFilePathLen = 0;
        String [] files = input.split("\n");
        
        int stackCharLen = 0;
        for(String file : files) {
            int numTabs = 0;
            int strIndex = 0;
            while(file.charAt(strIndex) == '\t') {
                numTabs++;
                strIndex++;
            }
            file = "/" + file.substring(strIndex);
            
            while(stack.size() != numTabs) {
                stackCharLen -= stack.peek().length();
                stack.pop();
            }
            stackCharLen += file.length();
            stack.push(file);
            if(file.contains(".")) {
                maxFilePathLen = (stackCharLen > maxFilePathLen) ? stackCharLen : maxFilePathLen;
            }
        }
        
        return maxFilePathLen - 1;
    }
}
