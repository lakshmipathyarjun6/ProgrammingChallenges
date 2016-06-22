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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            List<Integer> emptyList = new LinkedList<Integer>();
            return emptyList;
        }
        
        List<Integer> llist = preorderTraversal(root.left);
        List<Integer> rlist = preorderTraversal(root.right);
        llist.addAll(rlist);
        llist.add(0,root.val);
        
        return llist;
    }
}