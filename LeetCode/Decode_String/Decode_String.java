public class Solution {
    public String decodeString(String s) {
        String output = "";
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        Integer currNum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(Character.isLetter(ch)) {
                if(intStack.empty()) {
                    output += ch;
                }
                else {
                    String topString = strStack.pop();
                    topString += ch;
                    strStack.push(topString);
                }
            }
            else if(Character.isDigit(ch)) {
                currNum = currNum*10 + (ch - '0');
            }
            else {
                if(ch == '[') {
                    intStack.push(currNum);
                    strStack.push("");
                    currNum = 0;
                }
                else { // must be ']'
                    String toAppend = generateRepeatedSequence(strStack.peek(), intStack.peek());
                    intStack.pop();
                    strStack.pop();
                    String newStr = (strStack.empty()) ? "" : strStack.pop();
                    newStr += toAppend;
                    strStack.push(newStr);
                    if(intStack.empty()) {
                        output += strStack.pop();
                    }
                }
            }
        }
        
        return output;
    }
    
    private String generateRepeatedSequence(String seq, Integer times) {
        String output = "";
        while(times > 0) {
            output += seq;
            times--;
        }
        return output;
    }
}
