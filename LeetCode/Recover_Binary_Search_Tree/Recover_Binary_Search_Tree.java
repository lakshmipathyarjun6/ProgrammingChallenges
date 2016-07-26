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
    
    TreeNode anomaly1;
    TreeNode anomaly2;
    TreeNode lastVisited;
    
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        
        segment(root);
        
        int temp = anomaly1.val;
        anomaly1.val = anomaly2.val;
        anomaly2.val = temp;
    }
    
    public void segment(TreeNode root) {
        if(root == null) {
            return;
        }
        
        segment(root.left);
        if(lastVisited != null) {
            if(lastVisited.val > root.val) {
                if(anomaly1 == null) {
                    anomaly1 = lastVisited;
                }
                anomaly2 = root;
            }
        }
        lastVisited = root;
        segment(root.right);
    }
}
