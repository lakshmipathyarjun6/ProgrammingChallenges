/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private void dfs(TreeNode root, List<List<String>> allPaths, List<String> curr) {
        
        curr.add(String.valueOf(root.val));
        
        if(root.left == null && root.right == null) {
            allPaths.add(curr);
            return;
        }
        
        if(root.left != null) {
            List<String> temp = new ArrayList<String>(curr);
            dfs(root.left, allPaths, temp);
        }
        
        if(root.right != null) {
            List<String> temp = new ArrayList<String>(curr);
            dfs(root.right, allPaths, temp);
        }
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<String>();
        
        if(root == null) {
            return allPaths;
        }
        
        List<String> curr = new ArrayList<String>();
        List<List<String>> results = new ArrayList<List<String>>();

        dfs(root, results, curr);
        
        for(List<String> al : results) {
            StringBuilder sb = new StringBuilder();
            sb.append(al.get(0));
            for(int i=1; i<al.size();i++) {
                sb.append("->"+al.get(i));
            }
 
            allPaths.add(sb.toString());
        }
        
        return allPaths;
        
    }
}
