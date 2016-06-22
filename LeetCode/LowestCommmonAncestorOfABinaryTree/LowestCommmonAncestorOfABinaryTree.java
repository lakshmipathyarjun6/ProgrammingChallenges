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
    
    private boolean coversTree(TreeNode root, TreeNode p) {
        if(root == null) {
            return false;
        }
        if(root == p) {
            return true;
        }
        return coversTree(root.left,p) || coversTree(root.right,p);
    }
    
    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p) {
            return p;
        }
        if(root == q) {
            return q;
        }
        
        boolean pOnLeftSide = coversTree(root.left,p);
        boolean qOnLeftSide = coversTree(root.left,q);
        
        if(pOnLeftSide && qOnLeftSide) {
            return lowestCommonAncestorHelper(root.left,p,q);
        }
        if(!pOnLeftSide && !qOnLeftSide) {
            return lowestCommonAncestorHelper(root.right,p,q);
        }
        else {
            return root;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(!coversTree(root,p) || !coversTree(root,q)) {
            return null;
        }
        return lowestCommonAncestorHelper(root, p, q);
    }
}