public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Pair> stack = new Stack<Pair>();
        int totalCombs = 0;
 
        for(int i=0; i < s.length(); i++){
            char paren = s.charAt(i);
            if(paren == '('){
                Pair leftParen = new Pair(i,paren);
                stack.push(leftParen);
            }
            else{
                if(stack.empty() || stack.peek().type == ')'){
                    Pair rightParen = new Pair(i,paren);
                    stack.push(rightParen);
                }
                else{
                    stack.pop();
                    int currentLen = (stack.empty()) ? i+1 : i-stack.peek().val;
                    totalCombs = Math.max(totalCombs, currentLen);
                }
            }
        }
 
        return totalCombs;
    }
}

class Pair {
    int val;
    char type;
    
    public Pair(int value, char orientation) {
        val = value;
        type = orientation;
    }
}
