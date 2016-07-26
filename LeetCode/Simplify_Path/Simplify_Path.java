public class Solution {
    public String simplifyPath(String path) {
        String [] parts = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String dir : parts) {
            if(dir.equals("") || dir.equals(".")) {
                continue;
            }
            else if(dir.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(dir);
            }
        }
        
        if(stack.empty()) {
            return "/";
        }
        
        StringBuffer buff = new StringBuffer();
        while(!stack.empty()) {
            buff.insert(0,stack.pop());
            buff.insert(0,"/");
        }
        
        return buff.toString();
    }
}
