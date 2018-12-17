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
    public int getNextNodeValue(TreeNode n) {
        int val = n.val;
        while(n.left != null) {
            val = n.left.val;
            n = n.left;
        }
        return val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        
        else {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            
            int nextKey = getNextNodeValue(root.right);
            root.val = nextKey;
            
            root.right = deleteNode(root.right, nextKey);
        }
        
        return root;
    }
}
