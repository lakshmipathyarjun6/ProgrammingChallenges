public class Solution {
    
    Stack<Integer> operands;
    Stack<Character> operators;
    
    public int calculate(String s) {
        String trimmed = s.replaceAll("\\s+","");
        
        operands = new Stack<Integer>();
        operators = new Stack<Character>();
        
        int currentNumber = -100;
        for(int i = 0; i < trimmed.length(); i++) {
            Character ch = trimmed.charAt(i);
            if(Character.isDigit(ch)) {
                int val = Character.getNumericValue(ch);
                currentNumber = (currentNumber == -100) ? val : currentNumber*10 + val;
            }
            else {
                if(ch == '(') {
                    operators.push(ch);
                }
                else if(ch == ')') {
                    if(currentNumber != -100) {
                        operands.push(currentNumber);
                    }
                    evaluate(true);
                }
                else {
                    if(currentNumber != -100) {
                        operands.push(currentNumber);
                    }
                    evaluate(false);
                    operators.push(ch);
                }
                currentNumber = -100;
            }
        }
        
        if(currentNumber != -100 || operators.size() > 0) {
            if(currentNumber != -100) {
                operands.push(currentNumber);
            }
            evaluate(true);
        }
        
        return operands.pop();
    }
    
    public void evaluate(boolean removeLeftParen) {
        
        while(!operators.empty() && operators.peek() != '(') {
            Integer secondVal = operands.pop();
            Integer firstVal = operands.pop();
            Character symbol = operators.pop();
            
            Integer result = 0;
            switch(symbol) {
                case '+':
                    result = firstVal + secondVal;
                    break;
                case '-':
                    result = firstVal - secondVal;
                    break;
            }
            //System.out.println(firstVal + " " + secondVal + " " + result);
            
            operands.push(result);
        }
        
        if(removeLeftParen && !operators.empty() && operators.peek() == '(') {
            operators.pop();
        }
    }
    
}

