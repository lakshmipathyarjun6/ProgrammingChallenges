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
    private boolean hasPathSumHelper(TreeNode root, int sum) {
        if(root.left == null && root.right == null) { // reached leaf node
            return (sum - root.val) == 0;
        }
        int newVal = sum - root.val;
        if(root.left != null && root.right != null) {
            return hasPathSumHelper(root.left, newVal) || hasPathSumHelper(root.right, newVal);
        }
        else if(root.left != null) {
            return hasPathSumHelper(root.left, newVal);
        }
        else {
            return hasPathSumHelper(root.right, newVal);
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return hasPathSumHelper(root,sum);
    }
}