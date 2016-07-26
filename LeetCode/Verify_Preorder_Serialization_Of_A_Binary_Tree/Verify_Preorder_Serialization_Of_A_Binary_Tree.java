import java.util.*;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> items = new ArrayList<String>(Arrays.asList(preorder.split("\\s*,\\s*")));
        
        if(items.size() == 1 && items.get(0) == "#") {
            return true;
        }
        
        Stack<String> validation = new Stack<String>();
        
        for(int i = 0; i < items.size(); i++) {
            String ch = items.get(i);
            System.out.println(ch);
            
            if(!ch.equals("#")) {
                validation.push(ch);
            }
            
            else {
                if(validation.empty() || !validation.peek().equals("#")) {
                    validation.push(ch);
                }
                else {
                    do {
                        validation.pop();
                        if(validation.empty()) {
                            return false;
                        }
                        validation.pop();
                    }
                    while(!validation.empty() && validation.peek().equals("#"));
                    validation.push(ch);
                }
            }
        }
        
        if(!(validation.size() == 1 && validation.peek().equals("#"))) {
            return false;
        }
        
        return true;
    }
}