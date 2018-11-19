/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger finalResult = null; 
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        Integer val = null;
        boolean negative = false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[') {
                stack.push(new NestedInteger());
            }
            else if(ch == ']' || ch == ',') {
                if(val != null) {
                    val = (negative) ? -val : val;
                    stack.peek().add(new NestedInteger(val));
                    negative = false;
                }
                val = null;
                if(ch == ']') {
                    NestedInteger ni = stack.pop();
                    if(stack.size() > 0) {
                        stack.peek().add(ni);
                    }
                    else {
                        finalResult = ni;
                    }
                }                
            }
            else if(ch == '-') {
                negative = true;
            }
            else {
                val = (val != null) ? 10 * val + (ch - '0') : (ch - '0'); 
            }
        }
        if(val != null) {
            val = (negative) ? -val : val; 
            finalResult = new NestedInteger(val);
        }
        return finalResult;
    }
}
