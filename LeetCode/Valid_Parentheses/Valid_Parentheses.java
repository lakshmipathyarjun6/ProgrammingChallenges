public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if(st.empty()) {
                    return false;
                }
                Character topChar = st.pop();
                switch(ch) {
                    case ')':
                        if(topChar != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if(topChar != '{') {
                            return false;
                        }
                        break;
                    default:
                        if(topChar != '[') {
                            return false;
                        }
                        break;
                }
            }
        }
        
        if(!st.empty()) {
            return false;
        }
        
        return true;
    }
}