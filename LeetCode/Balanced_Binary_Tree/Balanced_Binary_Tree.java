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
    private int checkHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) {
            return -1;
        }
        
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) {
            return -1;
        }
        else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root) == -1) {
            return false;
        }
        return true;
    }
}