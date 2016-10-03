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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }
    
    private int sumOfLeftLeavesHelper(TreeNode root, boolean leftBranch) {
        if(root == null) {
            return 0;
        }
        else if(root.left == null && root.right == null && leftBranch) {
            return root.val;
        }
        
        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }
}
