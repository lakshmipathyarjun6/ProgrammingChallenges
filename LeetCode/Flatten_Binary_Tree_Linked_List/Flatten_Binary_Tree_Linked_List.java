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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode rs = helper(root.right);
        TreeNode ls = helper(root.left);
        
        if(ls != null) {
            TreeNode lsBottom = ls;
            while(lsBottom.right != null) {
                lsBottom = lsBottom.right;
            }
            lsBottom.right = rs;
            root.right = ls;
        }
        else {
            root.right = rs;
        }
        root.left = null;
        
        return root;
    }
}
