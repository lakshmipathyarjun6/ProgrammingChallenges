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
    
    private int maxDepthHelper(TreeNode root, int depth) {
        if(root.left == null && root.right == null) {
            return depth;
        }
        else if(root.left != null && root.right != null) {
            return Math.max(maxDepthHelper(root.left,depth+1),maxDepthHelper(root.right,depth+1));
        }
        else if(root.left == null) {
            return maxDepthHelper(root.right,depth+1);
        }
        else {
            return maxDepthHelper(root.left,depth+1);
        }
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return maxDepthHelper(root,1);
    }
}