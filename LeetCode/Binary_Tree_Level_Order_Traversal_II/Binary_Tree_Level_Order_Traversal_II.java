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
    
    public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> nodes, int depth, int maxDepth) {
        if(root == null) {
            return;
        }
        
        nodes.get(maxDepth-depth).add(root.val);
        
        levelOrderBottomHelper(root.left,nodes,depth+1,maxDepth);
        levelOrderBottomHelper(root.right,nodes,depth+1,maxDepth);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> retVal = new ArrayList<List<Integer>>();
        if(root == null) {
            return retVal;
        }
        
        int depth = maxDepth(root);
        for(int i = 0; i < depth; i++) {
            List<Integer> layer = new ArrayList<Integer>();
            retVal.add(layer);
        }
        
        levelOrderBottomHelper(root, retVal, 1, depth);
        
        return retVal;
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } 
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
 
            /* use the larger one */
            return Math.max(lDepth,rDepth) + 1;
        }
    }
}
