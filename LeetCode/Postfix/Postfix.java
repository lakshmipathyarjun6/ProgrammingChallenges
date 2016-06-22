import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
        String expression = "6 9 3 / + 2 -";
        String [] expressionParts = expression.split("\\s+");
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String s : expressionParts) {
            if(isInteger(s)) {
                stack.push(Integer.parseInt(s));
            }
            else {
                
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                
                switch(s) {
                    case "+":
                        stack.push(new Integer(op1 + op2));
                        break;
                    case "-":
                        stack.push(new Integer(op1 - op2));
                        break;
                    case "*":
                        stack.push(new Integer(op1 * op2));
                        break;
                    case "/":
                        stack.push(new Integer(op1 / op2));
                        break;
                    default:
                        System.out.println("Not a valid operator");
                }
            }
        }
        
        System.out.println(stack.peek().toString());
        
    }
    
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            
            // s is a valid integer
            
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
            // s is not an integer
        }
        
        return isValidInteger;
    }
}
