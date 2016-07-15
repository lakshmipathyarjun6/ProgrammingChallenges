public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        
        for(String token : tokens) {
            try {
                operands.push(Integer.parseInt(token));
            }
            catch(NumberFormatException e) {
                Integer operand2 = operands.pop();
                Integer operand1 = operands.pop();
                
                switch(token) {
                    case "+":
                        operands.push(operand1 + operand2);
                        break;
                    case "-":
                        operands.push(operand1 - operand2);
                        break;
                    case "*":
                        operands.push(operand1 * operand2);
                        break;
                    default:
                        operands.push(operand1 / operand2);
                        break;
                }
            }
        }
        
        return operands.pop();
    }
}
