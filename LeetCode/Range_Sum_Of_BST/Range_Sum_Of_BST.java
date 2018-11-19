/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int total;
    public void searchBST(TreeNode node, int L, int R) {
        if(node == null) {
            return;
        }
        if(node.val >= L && node.val <= R) {
            total += node.val;
            searchBST(node.left, L, R);
            searchBST(node.right, L, R);
        }
        else if(node.val < L) {
            searchBST(node.right, L, R);
        }
        else if(node.val > R) {
            searchBST(node.left, L, R);
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        total = 0;
        searchBST(root, L, R);
        return total;
    }
}
