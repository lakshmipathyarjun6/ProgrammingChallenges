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
    private int sumNumbersHelper(TreeNode root, int prevVal) {
        if(root == null) {
            return 0;
        }
        else if(root.left == null && root.right == null) { // leaf node
            return root.val + prevVal;
        }
        else {
            int computedVal = 10*(prevVal+root.val);
            return sumNumbersHelper(root.left,computedVal) + sumNumbersHelper(root.right,computedVal);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
}