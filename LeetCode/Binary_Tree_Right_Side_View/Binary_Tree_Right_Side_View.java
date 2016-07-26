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
    
    private List<List<TreeNode>> createLevelList(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        List<TreeNode> current = new LinkedList<TreeNode>();
        
        if(root != null) {
            current.add(root);
        }
        
        while(current.size() > 0) {
            result.add(current);
            List<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            
            for(TreeNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        
        return result;
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<List<TreeNode>> levelList = createLevelList(root);
        List<Integer> result = new LinkedList<Integer>();
        
        for(List<TreeNode> ls : levelList) {
            result.add(ls.get(ls.size()-1).val);
        }
        
        return result;
    }
}