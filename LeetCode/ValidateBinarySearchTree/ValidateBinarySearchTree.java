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
    
    private boolean isValidBSTHelper(TreeNode root, Integer lb, Integer ub) {
        if(root == null) {
            return true;
        }
        if(lb != null && root.val <= lb) {
            return false;
        }
        if(ub != null && root.val >= ub) {
            return false;
        }
        return (isValidBSTHelper(root.left, lb, root.val) && isValidBSTHelper(root.right, root.val, ub));
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,null,null);
    }
}