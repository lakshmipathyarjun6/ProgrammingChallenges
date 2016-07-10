public class Solution {
    
    private void dfs(List<String> allPerms, String s, int left, int right) {
        if(left > right) {
            return;
        }
        
        if(left == 0 && right == 0) {
            allPerms.add(s);
            return;
        }
        
        if(left > 0) {
            dfs(allPerms, s + "(", left-1, right);
        }
        
        if(right > 0) {
            dfs(allPerms, s + ")", left, right-1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> allPerms = new LinkedList<String>();
        dfs(allPerms,"",n,n);
        return allPerms;
        
    }
}
