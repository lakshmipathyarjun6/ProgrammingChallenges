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
    public int minDepthHelper(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        return 1 + Math.min(minDepthHelper(root.left),minDepthHelper(root.right));
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return minDepthHelper(root);
    }
}
